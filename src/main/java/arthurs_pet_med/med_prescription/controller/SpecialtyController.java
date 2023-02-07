package arthurs_pet_med.med_prescription.controller;

import arthurs_pet_med.med_prescription.dto.SpecialtyPrescriptionDto;
import arthurs_pet_med.med_prescription.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialty")
public class SpecialtyController {

  private final SpecialtyService specialtyService;

  @GetMapping("")
  public SpecialtyPrescriptionDto getSpecialty(@RequestParam List<String> symptoms) {
    return specialtyService.getSpecialtyPrescriptionDto(symptoms);
  }
}
