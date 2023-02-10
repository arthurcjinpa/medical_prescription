package arthurs_pet_med.med_prescription.impl;

import arthurs_pet_med.med_prescription.BaseTest;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymptomsServiceImplTest extends BaseTest {

  @Test
  @Transactional
  public void getAllSymptomsTest() {
    // given
    int repositorySize = prescriptionRepository.findAll().size();

    // when
    int serviceSize = prescriptionService.showAllPrescriptions().size();

    // then
    assertEquals(repositorySize, serviceSize);
  }
}
