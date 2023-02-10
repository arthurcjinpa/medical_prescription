package arthurs_pet_med.med_prescription.entity.drools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
