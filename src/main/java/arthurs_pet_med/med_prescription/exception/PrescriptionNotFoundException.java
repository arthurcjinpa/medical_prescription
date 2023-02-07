package arthurs_pet_med.med_prescription.exception;

public class PrescriptionNotFoundException extends RuntimeException {
  public PrescriptionNotFoundException(String message) {
    super(message);
  }
}
