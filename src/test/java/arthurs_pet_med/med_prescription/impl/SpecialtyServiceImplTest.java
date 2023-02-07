package arthurs_pet_med.med_prescription.impl;

import arthurs_pet_med.med_prescription.BaseTest;
import arthurs_pet_med.med_prescription.enums.Specialty;
import org.junit.Test;

import java.util.List;

import static arthurs_pet_med.med_prescription.enums.Specialty.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialtyServiceImplTest extends BaseTest {

    @Test
    public void getSpecialtyBySymptomsTest() {
        // given
        List<String> symptomsForOphthalmologist = List.of("eye redness","glare from lights","headache");
        List<String> symptomsForGastroenterologist = List.of("diarrhea","heartburn","headache","vomiting","nausea");
        List<String> symptomsForTherapist = List.of("headache");

        // when
        Specialty specialtyOphthalmologistBySymptoms = specialtyService.getSpecialtyBySymptoms(symptomsForOphthalmologist);
        Specialty specialtyGastroenterologistBySymptoms = specialtyService.getSpecialtyBySymptoms(symptomsForGastroenterologist);
        Specialty specialtyTherapistBySymptoms = specialtyService.getSpecialtyBySymptoms(symptomsForTherapist);

        // then
        assertEquals(OPHTHALMOLOGIST, specialtyOphthalmologistBySymptoms);
        assertEquals(GASTROENTEROLOGIST, specialtyGastroenterologistBySymptoms);
        assertEquals(THERAPIST, specialtyTherapistBySymptoms);
    }

}
