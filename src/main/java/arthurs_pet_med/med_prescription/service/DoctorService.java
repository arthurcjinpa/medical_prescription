package arthurs_pet_med.med_prescription.service;

import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.enums.Specialty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {

    Doctor findDoctorById(Long id);

    Doctor addDoctor(Doctor doctor);

    List<Doctor> findFreeDoctors(Specialty specialty);
}
