package arthurs_pet_med.med_prescription.service.impl;

import arthurs_pet_med.med_prescription.dto.DoctorDto;
import arthurs_pet_med.med_prescription.dto.SpecialtyPrescriptionDto;
import arthurs_pet_med.med_prescription.enums.Specialty;
import arthurs_pet_med.med_prescription.mapper.PrescriptionMapper;
import arthurs_pet_med.med_prescription.service.DoctorService;
import arthurs_pet_med.med_prescription.service.DroolsService;
import arthurs_pet_med.med_prescription.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static arthurs_pet_med.med_prescription.enums.Specialty.THERAPIST;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

  private final DroolsService droolsService;
  private final DoctorService doctorService;
  private final PrescriptionMapper prescriptionMapper;

  @Override
  public Specialty getSpecialtyBySymptoms(List<String> symptoms) {
    if (!CollectionUtils.isEmpty(symptoms)) {
      return Specialty.findByName(droolsService.getSpecialty(symptoms));
    }
    return THERAPIST;
  }

  @Override
  public SpecialtyPrescriptionDto getSpecialtyPrescriptionDto(List<String> symptoms) {
    Specialty specialty = getSpecialtyBySymptoms(symptoms);
    List<DoctorDto> doctors = doctorService.findAvailableDoctorDtosBySpecialty(specialty);
    return prescriptionMapper.doctorsAndSpecialtyAndSymptomsToDto(doctors, specialty, symptoms);
  }
}
