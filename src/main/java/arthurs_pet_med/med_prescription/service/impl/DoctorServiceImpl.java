package arthurs_pet_med.med_prescription.service.impl;

import arthurs_pet_med.med_prescription.dto.DoctorDto;
import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.enums.Specialty;
import arthurs_pet_med.med_prescription.exception.DoctorNotFoundException;
import arthurs_pet_med.med_prescription.mapper.DoctorMapper;
import arthurs_pet_med.med_prescription.repository.DoctorRepository;
import arthurs_pet_med.med_prescription.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

  private final DoctorRepository doctorRepository;
  private final DoctorMapper doctorMapper;

  @Override
  public Doctor findDoctorById(Long id) {
    return doctorRepository
        .findById(id)
        .orElseThrow(
            () -> {
              throw new DoctorNotFoundException("Doctor with id " + id + " was not found.");
            });
  }

  @Override
  public List<Doctor> findAllDoctors() {
    return doctorRepository.findAll();
  }

  @Override
  public Doctor addDoctor(Doctor doctor) {
    return doctorRepository.save(doctor);
  }

  @Override
  public List<DoctorDto> findAvailableDoctorDtosBySpecialty(Specialty specialty) {
    List<Doctor> doctors = findAvailableDoctorEntitiesBySpecialty(specialty);
    if (CollectionUtils.isEmpty(doctors)) {
      return new ArrayList<>();
    }
    return doctorMapper.entityListToDoctorDtoList(doctors);
  }

  private List<Doctor> findAvailableDoctorEntitiesBySpecialty(Specialty specialty) {
    return doctorRepository.findAllBySpecialtyAndAvailableTimeIsNotNull(specialty);
  }
}
