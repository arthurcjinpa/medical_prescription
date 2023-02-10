package arthurs_pet_med.med_prescription.enums;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

public enum Specialty {
  THERAPIST,
  GASTROENTEROLOGIST,
  ORTHODONTIST,
  OPHTHALMOLOGIST;

  public static Specialty findByName(String name) {
    return Arrays.stream(Specialty.values())
        .filter(value -> value.name().equalsIgnoreCase(name))
        .findFirst()
        .orElseThrow(
            () -> {
              throw new EntityNotFoundException("Specialty with name " + name + " was not found.");
            });
  }
}
