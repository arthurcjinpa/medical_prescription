package arthurs_pet_med.med_prescription.dto;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionConfirmationDto {
    private Long prescriptionId;
    private Long doctorId;
    private ZonedDateTime chosenTime;
    private boolean approved;
}
