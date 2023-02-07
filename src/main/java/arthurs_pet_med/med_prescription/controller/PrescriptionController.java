package arthurs_pet_med.med_prescription.controller;

import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionDto;
import arthurs_pet_med.med_prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PrescriptionController {

  private final PrescriptionService prescriptionService;

  @GetMapping("/list")
  public List<PrescriptionDto> allPrescriptions() {
    return prescriptionService.showAllPrescriptions();
  }

  @PostMapping("/confirmation")
  public ResponseEntity<String> prescriptionConfirmation(
      @RequestBody PrescriptionConfirmationDto confirmationDto) {
    String message = prescriptionService.prescriptionConfirmation(confirmationDto);
    return new ResponseEntity<>(message, HttpStatus.OK);
  }
}
