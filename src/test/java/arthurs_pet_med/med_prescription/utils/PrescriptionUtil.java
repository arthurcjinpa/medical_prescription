package arthurs_pet_med.med_prescription.utils;

import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.entity.Doctor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class PrescriptionUtil {

  public PrescriptionConfirmationDto createGastroenterologistConfirmationDto() {
    return PrescriptionConfirmationDto.builder()
        .context("context here")
        .specialty("GASTROENTEROLOGIST")
        .chosenTime(ZonedDateTime.of(2023, 2, 15, 12, 0, 0, 0, ZoneId.systemDefault()))
        .symptoms(List.of("diarrhea", "sensitivity to light", "jaw pain", "nausea"))
        .userId(1L)
        .doctorId(2L)
        .approved(true)
        .build();
  }

  public PrescriptionConfirmationDto createOrthodontistConfirmationDto() {
    return PrescriptionConfirmationDto.builder()
        .context("context there")
        .specialty("ORTHODONTIST")
        .chosenTime(ZonedDateTime.of(2023, 2, 1, 13, 30, 0, 0, ZoneId.systemDefault()))
        .symptoms(List.of("jaw pain", "tooth decay", "headache"))
        .userId(2L)
        .doctorId(4L)
        .approved(true)
        .build();
  }

  public PrescriptionConfirmationDto createTherapistConfirmationDto() {
    return PrescriptionConfirmationDto.builder()
        .context("context there")
        .specialty("THERAPIST")
        .chosenTime(ZonedDateTime.of(2023, 3, 3, 13, 30, 0, 0, ZoneId.systemDefault()))
        .symptoms(List.of("not sure"))
        .userId(3L)
        .doctorId(5L)
        .approved(true)
        .build();
  }

  public PrescriptionConfirmationDto createConfirmationDtoByDoctor(Doctor doctor) {
    return PrescriptionConfirmationDto.builder()
        .context("context there")
        .specialty(doctor.getSpecialty().name())
        .chosenTime(ZonedDateTime.of(2023, 2, 15, 12, 0, 0, 0, ZoneId.systemDefault()))
        .symptoms(List.of("jaw pain", "tooth decay", "headache"))
        .userId(2L)
        .doctorId(doctor.getId())
        .approved(true)
        .build();
  }
}
