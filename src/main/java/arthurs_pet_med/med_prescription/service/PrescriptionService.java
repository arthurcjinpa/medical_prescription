package arthurs_pet_med.med_prescription.service;

import arthurs_pet_med.med_prescription.dto.PrescriptionConfirmationDto;
import arthurs_pet_med.med_prescription.dto.PrescriptionDto;
import arthurs_pet_med.med_prescription.entity.Prescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrescriptionService {
    List<PrescriptionDto> showAllPrescriptions();

    void deleteAllPrescriptions();

    Prescription findPrescriptionById(Long id);

    Prescription addPrescription(Prescription prescription);

    String prescriptionConfirmation(PrescriptionConfirmationDto confirmationDto);
}
