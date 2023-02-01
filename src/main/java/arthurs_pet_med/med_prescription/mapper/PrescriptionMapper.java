package arthurs_pet_med.med_prescription.mapper;

import arthurs_pet_med.med_prescription.dto.DoctorDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.entity.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.time.ZonedDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = ZonedDateTime.class, uses = DoctorMapper.class)
public interface PrescriptionMapper {

    @Mapping(target = "prescriptionId", source = "id")
    @Mapping(target = "availableDoctors", qualifiedByName = "entityListToDoctorDtoList", source = "prescription.doctors")
    PrescriptionDto entityToPrescriptionDto(Prescription prescription);

    Prescription prescriptionDtoToEntity(List<Doctor> doctors, PrescriptionDto prescriptionDto);

    default PrescriptionDto doctorDtoListToPrescriptionDto(List<DoctorDto> availableDoctors) {
        return PrescriptionDto.builder()
                .availableDoctors(availableDoctors).build();
    }
}
