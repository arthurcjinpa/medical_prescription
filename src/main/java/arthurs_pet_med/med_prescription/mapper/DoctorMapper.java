package arthurs_pet_med.med_prescription.mapper;

import arthurs_pet_med.med_prescription.dto.DoctorDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;

import java.time.ZonedDateTime;
import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        imports = ZonedDateTime.class)
public interface DoctorMapper {

    @Named("entityListToDoctorDtoList")
    List<DoctorDto> entityListToDoctorDtoList(List<Doctor> doctors);

    default DoctorDto entityListToDoctorDtoList(Doctor doctor) {
        return DoctorDto.builder()
                .doctorId(doctor.getId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .doctorId(doctor.getId())
                .availableTime(doctor.getAvailableTime())
                .price(doctor.getPrice())
                .specialty(doctor.getSpecialty())
                .build();
    }
}
