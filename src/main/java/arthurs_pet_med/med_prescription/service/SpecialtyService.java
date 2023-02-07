package arthurs_pet_med.med_prescription.service;

import arthurs_pet_med.med_prescription.dto.SpecialtyPrescriptionDto;
import arthurs_pet_med.med_prescription.enums.Specialty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecialtyService {

  Specialty getSpecialtyBySymptoms(List<String> symptoms);

  SpecialtyPrescriptionDto getSpecialtyPrescriptionDto(List<String> symptoms);
}
