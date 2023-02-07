package arthurs_pet_med.med_prescription;

import arthurs_pet_med.med_prescription.repository.PrescriptionRepository;
import arthurs_pet_med.med_prescription.repository.SymptomsRepository;
import arthurs_pet_med.med_prescription.service.DoctorService;
import arthurs_pet_med.med_prescription.service.PrescriptionService;
import arthurs_pet_med.med_prescription.service.SpecialtyService;
import arthurs_pet_med.med_prescription.service.SymptomService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class BaseTest {
    @Autowired
    protected PrescriptionService prescriptionService;
    @Autowired
    protected PrescriptionRepository prescriptionRepository;
    @Autowired
    protected SymptomsRepository symptomsRepository;
    @Autowired
    protected SymptomService symptomService;
    @Autowired
    protected SpecialtyService specialtyService;
    @Autowired
    protected DoctorService doctorService;
}
