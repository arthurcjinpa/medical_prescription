package arthurs_pet_med.med_prescription.service.impl;

import arthurs_pet_med.med_prescription.dto.SpecialtyDto;
import arthurs_pet_med.med_prescription.entity.drools.Gastroenterologist;
import arthurs_pet_med.med_prescription.entity.drools.Ophthalmologist;
import arthurs_pet_med.med_prescription.entity.drools.Orthodontist;
import arthurs_pet_med.med_prescription.entity.drools.Specialty;
import arthurs_pet_med.med_prescription.repository.SymptomsRepository;
import arthurs_pet_med.med_prescription.service.DroolsService;
import lombok.RequiredArgsConstructor;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static arthurs_pet_med.med_prescription.enums.Specialty.*;

@Service
@RequiredArgsConstructor
public class DroolsServiceImpl implements DroolsService {

  private final SymptomsRepository symptomsRepository;

  @Override
  public String getSpecialty(List<String> usersSymptomList) {

    KieServices kieServices = KieServices.Factory.get();
    KieContainer kieContainer = kieServices.getKieClasspathContainer();
    KieSession kieSession = kieContainer.newKieSession();

    List<String> symptomsForOphthalmologist =
        new ArrayList<>(symptomsRepository.findBySpecialty(OPHTHALMOLOGIST.name()).getSymptoms());

    List<String> symptomsForGastroenterologist =
        new ArrayList<>(
            symptomsRepository.findBySpecialty(GASTROENTEROLOGIST.name()).getSymptoms());

    List<String> symptomsForOrthodontist =
        new ArrayList<>(symptomsRepository.findBySpecialty(ORTHODONTIST.name()).getSymptoms());

    SpecialtyDto specialtyDto = new SpecialtyDto();

    Specialty ophthalmologist = new Ophthalmologist(symptomsForOphthalmologist);
    Specialty gastroenterologist = new Gastroenterologist(symptomsForGastroenterologist);
    Specialty orthodontist = new Orthodontist(symptomsForOrthodontist);

    kieSession.insert(ophthalmologist);
    kieSession.insert(gastroenterologist);
    kieSession.insert(orthodontist);

    kieSession.insert(usersSymptomList);

    kieSession.setGlobal("usersSymptomList", usersSymptomList);
    kieSession.setGlobal("specialtyDto", specialtyDto);

    kieSession.fireAllRules();

    kieSession.dispose();

    return specialtyDto.getSpecialty();
  }
}
