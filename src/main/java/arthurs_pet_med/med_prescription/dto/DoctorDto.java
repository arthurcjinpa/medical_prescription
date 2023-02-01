package arthurs_pet_med.med_prescription.dto;

import arthurs_pet_med.med_prescription.enums.Specialty;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long doctorId;
    private Specialty specialty;
    private String firstName;
    private String lastName;
    private Long price;
    private List<ZonedDateTime> availableTime;
}
