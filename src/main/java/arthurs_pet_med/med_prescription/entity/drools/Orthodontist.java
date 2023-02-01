package arthurs_pet_med.med_prescription.entity.drools;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orthodontist extends Specialty {
    String specialty = "Orthodontist";
    List<String> symptoms;

    public Orthodontist(List<String> symptoms) {
        this.symptoms = symptoms;
    }
}
