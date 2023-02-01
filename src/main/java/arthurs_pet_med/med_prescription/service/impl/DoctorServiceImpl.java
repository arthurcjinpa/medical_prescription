package arthurs_pet_med.med_prescription.service.impl;

import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.enums.Specialty;
import arthurs_pet_med.med_prescription.exception.DoctorNotFoundException;
import arthurs_pet_med.med_prescription.repository.DoctorRepository;
import arthurs_pet_med.med_prescription.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            throw new DoctorNotFoundException("Doctor with id " + id + " not found.");
                        });
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findFreeDoctors(Specialty specialty) {
        return doctorRepository.findAllBySpecialtyAndAvailableTimeIsNotNull(specialty);
    }
}
