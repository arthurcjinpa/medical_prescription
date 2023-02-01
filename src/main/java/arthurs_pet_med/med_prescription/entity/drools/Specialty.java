package arthurs_pet_med.med_prescription.entity.drools;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Specialty {
    String specialty;
    List<String> symptoms;
}
