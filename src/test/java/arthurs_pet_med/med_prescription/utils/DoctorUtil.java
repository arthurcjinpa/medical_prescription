package arthurs_pet_med.med_prescription.utils;

import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.enums.Specialty;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

import static arthurs_pet_med.med_prescription.enums.Sex.W;

public class DoctorUtil {
    public Doctor createDoctor(Specialty specialty) {
        return Doctor.builder()
                .email("doctor@mail.com")
                .specialty(specialty)
                .sex(W)
                .availableTime(
                        new ArrayList<>(
                                Collections.singleton(ZonedDateTime.of(2023, 2, 15, 12, 0, 0, 0, ZoneId.systemDefault()))
                        ))
                .firstName("first name")
                .lastName("last name")
                .experience(4)
                .price(1000L)
                .prescriptions(new ArrayList<>())
                .build();
    }
}
