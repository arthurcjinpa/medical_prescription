package arthurs_pet_med.med_prescription;

import arthurs_pet_med.med_prescription.entity.Doctor;
import arthurs_pet_med.med_prescription.entity.Symptoms;
import arthurs_pet_med.med_prescription.repository.DoctorRepository;
import arthurs_pet_med.med_prescription.repository.SymptomsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static arthurs_pet_med.med_prescription.enums.Sex.M;
import static arthurs_pet_med.med_prescription.enums.Sex.W;
import static arthurs_pet_med.med_prescription.enums.Specialty.*;

@SpringBootApplication
public class MedPrescriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedPrescriptionApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DoctorRepository doctorRepository, SymptomsRepository symptomsRepository) {
		return args -> {
			doctorRepository.save(new Doctor(1L, OPHTHALMOLOGIST, "Arthur", "Babaev", 3,
					M, 1500L, "arthur@mail.com",
					List.of(ZonedDateTime.of(2023, 2, 1, 14, 30, 0, 0, ZoneId.systemDefault()),
							ZonedDateTime.of(2023, 2, 1, 17, 0, 0, 0, ZoneId.systemDefault()),
							ZonedDateTime.of(2023, 2, 7, 14, 30, 0, 0, ZoneId.systemDefault()))));

			doctorRepository.save(new Doctor(2L, GASTROENTEROLOGIST, "Andrew", "Gaza", 10,
					M, 3000L, "andrew@mail.com",
					List.of(ZonedDateTime.of(2023, 2, 15, 12, 0, 0, 0, ZoneId.systemDefault()),
							ZonedDateTime.of(2023, 3, 15, 12, 30, 0, 0, ZoneId.systemDefault()))));

			doctorRepository.save(new Doctor(3L, OPHTHALMOLOGIST, "Gurebu", "Swok", 10,
					M, 3000L, "swok@mail.com", null));

			doctorRepository.save(new Doctor(4L, ORTHODONTIST, "Julia", "Mighty", 15,
					W, 15000L, "julia@mail.com",
					List.of(ZonedDateTime.of(2023, 2, 1, 13, 30, 0, 0, ZoneId.systemDefault()),
							ZonedDateTime.of(2023, 2, 5, 14, 0, 0, 0, ZoneId.systemDefault()),
							ZonedDateTime.of(2023, 2, 15, 13, 30, 0, 0, ZoneId.systemDefault()))));

			symptomsRepository.save(new Symptoms(1L, "GASTROENTEROLOGIST", List.of("diarrhea,heartburn,headache,vomiting,nausea")));
			symptomsRepository.save(new Symptoms(2L, "ORTHODONTIST", List.of("jaw pain,tooth decay,headache,crowded teeth")));
			symptomsRepository.save(new Symptoms(3L, "OPHTHALMOLOGIST", List.of("eye redness,glare from lights,headache,sensitivity to light,weird sensation in eyes")));
		};
	}

}
