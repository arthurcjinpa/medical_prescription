package arthurs_pet_med.med_prescription.repository;

import arthurs_pet_med.med_prescription.entity.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomsRepository extends JpaRepository<Symptoms, Long> {
  Symptoms findBySpecialty(String specialty);
}
