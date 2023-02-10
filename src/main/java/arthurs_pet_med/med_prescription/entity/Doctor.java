package arthurs_pet_med.med_prescription.entity;

import arthurs_pet_med.med_prescription.enums.Sex;
import arthurs_pet_med.med_prescription.enums.Specialty;
import arthurs_pet_med.med_prescription.utils.DateToListConverter;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "SPECIALTY", nullable = false)
  private Specialty specialty;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "EXPERIENCE")
  private int experience;

  @Column(name = "SEX")
  private Sex sex;

  @Column(name = "PRICE")
  private Long price;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "AVAILABLE_TIME")
  @Convert(converter = DateToListConverter.class)
  private List<ZonedDateTime> availableTime;

  @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Prescription> prescriptions;

  public Doctor(
      Long id,
      Specialty specialty,
      String firstName,
      String lastName,
      int experience,
      Sex sex,
      Long price,
      String email,
      List<ZonedDateTime> availableTime) {
    this.id = id;
    this.specialty = specialty;
    this.firstName = firstName;
    this.lastName = lastName;
    this.experience = experience;
    this.sex = sex;
    this.price = price;
    this.email = email;
    this.availableTime = availableTime;
  }

  public Doctor(
      Specialty specialty,
      String firstName,
      String lastName,
      int experience,
      Sex sex,
      Long price,
      String email,
      List<ZonedDateTime> availableTime) {
    this.specialty = specialty;
    this.firstName = firstName;
    this.lastName = lastName;
    this.experience = experience;
    this.sex = sex;
    this.price = price;
    this.email = email;
    this.availableTime = availableTime;
  }
}
