package arthurs_pet_med.med_prescription.controller;

import arthurs_pet_med.med_prescription.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/symptoms")
public class SymptomsController {

    private final SymptomService symptomService;

    @GetMapping("/list")
    public List<String> getAllSymptoms() {
        return symptomService.getAllSymptoms();
    }
}
