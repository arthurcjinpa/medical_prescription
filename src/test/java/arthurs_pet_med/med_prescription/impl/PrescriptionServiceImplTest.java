package arthurs_pet_med.med_prescription.impl;

import arthurs_pet_med.med_prescription.BaseTest;
import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.utils.DoctorUtil;
import arthurs_pet_med.med_prescription.utils.PrescriptionUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static arthurs_pet_med.med_prescription.enums.Specialty.ORTHODONTIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
public class PrescriptionServiceImplTest extends BaseTest {

    private PrescriptionUtil prescriptionUtil;
    private DoctorUtil doctorUtil;

    @Before
    public void before() {
        prescriptionUtil = new PrescriptionUtil();
        doctorUtil = new DoctorUtil();
    }

    @Test
    public void showAllPrescriptionsTest() {
        // given
        int repositorySize = prescriptionRepository.findAll().size();

        // when
        int serviceSize = prescriptionService.showAllPrescriptions().size();

        // then
        assertEquals(repositorySize, serviceSize);
    }

    @Test
    @Transactional
    public void prescriptionConfirmationTest() {
        //given
        Doctor savedDoctor = doctorService.addDoctor(
                doctorUtil.createDoctor(ORTHODONTIST)
        );

        PrescriptionConfirmationDto confirmationDto =
                prescriptionUtil.createConfirmationDtoByDoctor(savedDoctor);

        //when
        String response =
                prescriptionService.prescriptionConfirmation(confirmationDto);

        //then
        assertEquals(response, "Thank you for your trust!\n" +
                "We'll be eagerly awaiting your arrival at the clinic,\n" +
                "ready to administer all the necessary check-ups and treatments!");

        assertEquals(1, doctorService.findDoctorById(confirmationDto.getDoctorId())
                .getPrescriptions().size());

        assertEquals(ORTHODONTIST.name(), doctorService.findDoctorById(confirmationDto.getDoctorId())
                .getPrescriptions().get(0).getSpecialty());
    }

    @Test
    public void findPrescriptionByIdTest() {
        //given
        Doctor savedDoctor = doctorService.addDoctor(
                doctorUtil.createDoctor(ORTHODONTIST)
        );

        PrescriptionConfirmationDto confirmationDto =
                prescriptionUtil.createConfirmationDtoByDoctor(savedDoctor);

        //when
        String response =
                prescriptionService.prescriptionConfirmation(confirmationDto);

        //then
        assertEquals(response, "Thank you for your trust!\n" +
                "We'll be eagerly awaiting your arrival at the clinic,\n" +
                "ready to administer all the necessary check-ups and treatments!");

        assertEquals(1, doctorService.findDoctorById(confirmationDto.getDoctorId())
                .getPrescriptions().size());

        assertEquals(ORTHODONTIST.name(), doctorService.findDoctorById(confirmationDto.getDoctorId())
                .getPrescriptions().get(0).getSpecialty());
    }





}
