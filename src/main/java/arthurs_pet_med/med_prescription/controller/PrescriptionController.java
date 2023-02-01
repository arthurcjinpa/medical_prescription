package arthurs_pet_med.med_prescription.controller;

import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionDto;
import arthurs_pet_med.med_prescription.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping("/list")
    public List<PrescriptionDto> allPrescriptions() {
        return prescriptionService.showAllPrescriptions();
    }

    @GetMapping("/application-process") //issue/prescription
    public PrescriptionDto issuePrescription(@RequestBody List<String> symptoms) {
        return prescriptionService.issuePrescription(symptoms);
    }

    @PostMapping("/confirmation")
    public String prescriptionConfirmation(@RequestBody PrescriptionConfirmationDto confirmationDto) {
        return prescriptionService.prescriptionConfirmation(confirmationDto);
    }
}