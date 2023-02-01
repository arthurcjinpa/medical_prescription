package arthurs_pet_med.med_prescription.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DroolsService {

    String getSpecialty(List<String> usersSymptomList);

}
