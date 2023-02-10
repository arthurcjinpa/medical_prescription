package arthurs_pet_med.med_prescription.service;

import arthurs_pet_med.med_prescription.enums.Specialty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SymptomService {
  List<String> getAllSymptoms();

  void addSymptomsToSpecialty(Specialty specialty, List<String> symptoms);
}
