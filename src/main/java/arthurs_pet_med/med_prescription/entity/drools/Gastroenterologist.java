package arthurs_pet_med.med_prescription.entity.drools;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gastroenterologist extends Specialty {
    String specialty = "Gastroenterologist";
    List<String> symptoms;

    public Gastroenterologist(List<String> symptoms) {
        this.symptoms = symptoms;
    }
}
