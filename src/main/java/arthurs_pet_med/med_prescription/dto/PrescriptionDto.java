package arthurs_pet_med.med_prescription.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {
    private Long prescriptionId;
    private List<DoctorDto> availableDoctors;
    private boolean approved;
}
