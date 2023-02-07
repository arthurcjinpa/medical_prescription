package arthurs_pet_med.med_prescription.service.impl;

import arthurs_pet_med.med_prescription.entity.Symptoms;
import arthurs_pet_med.med_prescription.enums.Specialty;
import arthurs_pet_med.med_prescription.repository.SymptomsRepository;
import arthurs_pet_med.med_prescription.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService {

    private final SymptomsRepository symptomsRepository;

    @Override
    public List<String> getAllSymptoms() {
        return symptomsRepository.findAll().stream()
                .map(Symptoms::getSymptoms)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public void addSymptomsToSpecialty(Specialty specialty, List<String> symptoms) {
        Symptoms symptomsBySpecialty = symptomsRepository.findBySpecialty(specialty.name());
        symptomsBySpecialty.getSymptoms().addAll(symptoms);
        symptomsRepository.save(symptomsBySpecialty);
    }
}
