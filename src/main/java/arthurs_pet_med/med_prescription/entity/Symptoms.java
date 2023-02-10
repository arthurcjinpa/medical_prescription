package arthurs_pet_med.med_prescription.entity;

import arthurs_pet_med.med_prescription.utils.StringToListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Symptoms {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "SPECIALTY")
  private String specialty;

  @Column(name = "SYMPTOMS")
  @Convert(converter = StringToListConverter.class)
  private List<String> symptoms;

  public Symptoms(String specialty, List<String> symptoms) {
    this.specialty = specialty;
    this.symptoms = symptoms;
  }
}
