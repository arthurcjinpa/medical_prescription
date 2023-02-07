package arthurs_pet_med.med_prescription.service.impl;

import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.entity.Prescription;
import arthurs_pet_med.med_prescription.exception.PrescriptionNotFoundException;
import arthurs_pet_med.med_prescription.exception.TimeIsUnavailableException;
import arthurs_pet_med.med_prescription.mapper.PrescriptionMapper;
import arthurs_pet_med.med_prescription.repository.DoctorRepository;
import arthurs_pet_med.med_prescription.repository.PrescriptionRepository;
import arthurs_pet_med.med_prescription.service.DoctorService;
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
    private final PrescriptionMapper prescriptionMapper;

    @Override
    public List<PrescriptionDto> showAllPrescriptions() {
        return prescriptionRepository.findAll().stream()
                .map(prescriptionMapper::entityToPrescriptionDto)
                    .collect(Collectors.toList());
    }

    @Override
    public void deleteAllPrescriptions() {
        prescriptionRepository.deleteAll();
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
    public String prescriptionConfirmation(PrescriptionConfirmationDto confirmationDto) {

        Doctor chosenDoctor = doctorService.findDoctorById(confirmationDto.getDoctorId());

        Prescription prescription = prescriptionMapper.confirmationDtoAndDoctorToEntity(confirmationDto, chosenDoctor);

            ZonedDateTime chosenDate = chosenDoctor.getAvailableTime().stream()
                    .filter(availableTime -> availableTime.isEqual(confirmationDto.getChosenTime()))
                    .findFirst()
                    .orElseThrow(
                            () -> {
                                throw new TimeIsUnavailableException(
                                        "Time - " + chosenDoctor.getAvailableTime() + " already taken."
                                );
                            });

            chosenDoctor.getPrescriptions().add(prescription);
            chosenDoctor.getAvailableTime().remove(chosenDate);
            doctorRepository.save(chosenDoctor);

            addPrescription(prescription);

            return "Thank you for your trust!\n" +
                    "We'll be eagerly awaiting your arrival at the clinic,\n" +
                    "ready to administer all the necessary check-ups and treatments!";
    }
}