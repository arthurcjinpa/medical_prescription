package arthurs_pet_med.med_prescription.repository;

import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.enums.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

  List<Doctor> findAllBySpecialtyAndAvailableTimeIsNotNull(Specialty specialty);
}
