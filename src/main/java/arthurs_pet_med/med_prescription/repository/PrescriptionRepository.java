package arthurs_pet_med.med_prescription.repository;

import arthurs_pet_med.med_prescription.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {}
