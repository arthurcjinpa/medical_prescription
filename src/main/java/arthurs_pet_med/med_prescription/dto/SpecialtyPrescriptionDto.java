package arthurs_pet_med.med_prescription.dto;

import arthurs_pet_med.med_prescription.enums.Specialty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyPrescriptionDto {
    private Specialty specialty;
    private List<DoctorDto> availableDoctors;
    private List<String> symptoms;
}
