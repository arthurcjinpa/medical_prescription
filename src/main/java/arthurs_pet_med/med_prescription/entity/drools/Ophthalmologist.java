package arthurs_pet_med.med_prescription.entity.drools;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ophthalmologist extends Specialty {
    String specialty = "Ophthalmologist";
    List<String> symptoms;

    public Ophthalmologist(List<String> symptoms) {
        this.symptoms = symptoms;
    }
}
