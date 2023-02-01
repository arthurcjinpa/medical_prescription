package arthurs_pet_med.med_prescription.entity;

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
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PRESCRIPTION_DOCTOR",
            joinColumns = @JoinColumn(name = "PRESCRIPTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "DOCTOR_ID"))
    private List<Doctor> doctors;

}
