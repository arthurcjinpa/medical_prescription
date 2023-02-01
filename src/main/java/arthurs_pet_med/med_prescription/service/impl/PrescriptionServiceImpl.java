package arthurs_pet_med.med_prescription.service.impl;

import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.entity.Prescription;
import arthurs_pet_med.med_prescription.enums.Specialty;
import arthurs_pet_med.med_prescription.exception.PrescriptionNotFoundException;
import arthurs_pet_med.med_prescription.exception.TimeIsUnavailableException;
import arthurs_pet_med.med_prescription.mapper.DoctorMapper;
import arthurs_pet_med.med_prescription.mapper.PrescriptionMapper;
import arthurs_pet_med.med_prescription.repository.DoctorRepository;
import arthurs_pet_med.med_prescription.repository.PrescriptionRepository;
import arthurs_pet_med.med_prescription.service.DoctorService;
import arthurs_pet_med.med_prescription.service.DroolsService;
import arthurs_pet_med.med_prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;
    private final DroolsService droolsService;
    private final PrescriptionMapper prescriptionMapper;
    private final DoctorMapper doctorMapper;

    @Override
    public List<PrescriptionDto> showAllPrescriptions() {
        return prescriptionRepository.findAll().stream()
                .map(prescriptionMapper::entityToPrescriptionDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Prescription findPrescriptionById(Long id) {
        return prescriptionRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            throw new PrescriptionNotFoundException("Prescription with id " + id + " not found.");
                        });
    }

    @Override
    public Prescription addPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }


    @Override
    @Transactional
    public PrescriptionDto issuePrescription(List<String> symptoms) {
         Specialty specialty = Specialty.findByName(
                 droolsService.getSpecialty(symptoms)
         );

         List<Doctor> doctors = doctorService.findFreeDoctors(specialty);

         PrescriptionDto prescriptionDto = prescriptionMapper.doctorDtoListToPrescriptionDto(
                 doctorMapper.entityListToDoctorDtoList(doctors)
         );

        Prescription prescription = addPrescription(
                prescriptionMapper.prescriptionDtoToEntity(doctors, prescriptionDto)
        );

        prescriptionDto.setPrescriptionId(prescription.getId());

        return prescriptionDto;
    }

    @Override
    public String prescriptionConfirmation(PrescriptionConfirmationDto confirmationDto) {

        Doctor chosenDoctor = doctorService.findDoctorById(confirmationDto.getDoctorId());
        Prescription savedPrescription = findPrescriptionById(confirmationDto.getPrescriptionId());

        if(confirmationDto.isApproved()) {
            ZonedDateTime chosenDate = chosenDoctor.getAvailableTime().stream()
                    .filter(availableTime -> availableTime.isEqual(confirmationDto.getChosenTime()))
                    .findFirst()
                    .orElseThrow(
                            () -> {
                                throw new TimeIsUnavailableException(
                                        "Time - " + chosenDoctor.getAvailableTime() + " already taken."
                                );
                            });
            chosenDoctor.getAvailableTime().remove(chosenDate);
            doctorRepository.save(chosenDoctor);

//            Prescription savedPrescription = findPrescriptionById(confirmationDto.getPrescriptionId());

//            chosenDoctor.getPrescriptions().add(savedPrescription);

            return "Thank you for your trust!\n" +
                    "We'll be eagerly awaiting your arrival at the clinic,\n" +
                    "ready to administer all the necessary check-ups and treatments!";
        } else {
            chosenDoctor.getPrescriptions().remove(savedPrescription);
        return "We are truly sorry that we could not find a convenient prescription for you!\n" +
                "Please come back later if you haven't found right time\n" +
                "or try to input another symptoms\n" +
                "if you are not sure about the correctness of the doctor's specialty!";
        }
    }
}