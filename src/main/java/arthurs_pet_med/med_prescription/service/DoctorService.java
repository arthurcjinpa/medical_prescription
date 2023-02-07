package arthurs_pet_med.med_prescription.service;

import arthurs_pet_med.med_prescription.dto.DoctorDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.enums.Specialty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {

    Doctor findDoctorById(Long id);

    List<Doctor> findAllDoctors();

    Doctor addDoctor(Doctor doctor);

    List<DoctorDto> findAvailableDoctorDtosBySpecialty(Specialty specialty);
}
