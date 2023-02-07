package arthurs_pet_med.med_prescription.dto;

import arthurs_pet_med.med_prescription.enums.Specialty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {
  private Long prescriptionId;
  private Specialty specialty;
  private Long userId;
  private Long doctorId;
  private Long price;
}
