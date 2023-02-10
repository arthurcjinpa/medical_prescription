package arthurs_pet_med.med_prescription.mapper;

import arthurs_pet_med.med_prescription.dto.DoctorDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionDto;
import arthurs_pet_med.med_prescription.dto.SpecialtyPrescriptionDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.entity.Prescription;
import arthurs_pet_med.med_prescription.enums.Specialty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.time.ZonedDateTime;
import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    imports = ZonedDateTime.class,
    uses = DoctorMapper.class)
public interface PrescriptionMapper {

  @Mapping(target = "prescriptionId", source = "id")
  @Mapping(target = "doctorId", source = "prescription.doctor.id")
  @Mapping(target = "price", source = "prescription.doctor.price")
  PrescriptionDto entityToPrescriptionDto(Prescription prescription);

  SpecialtyPrescriptionDto doctorsAndSpecialtyAndSymptomsToDto(
      List<DoctorDto> availableDoctors, Specialty specialty, List<String> symptoms);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "specialty", source = "confirmationDto.specialty")
  Prescription confirmationDtoAndDoctorToEntity(
      PrescriptionConfirmationDto confirmationDto, Doctor doctor);
}
