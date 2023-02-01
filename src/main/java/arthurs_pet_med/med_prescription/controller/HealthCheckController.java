package arthurs_pet_med.med_prescription.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthCheckController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("UP");
    }

    @GetMapping("/db")
    public ResponseEntity<String> healthDb() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return new ResponseEntity<>("UP", HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("DATABASE DOWN", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
