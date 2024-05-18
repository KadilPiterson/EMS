package pl.ems.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ems.ems.model.Registration;
import pl.ems.ems.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration) {
        Registration savedRegistration = registrationService.saveRegistration(registration);
        return new ResponseEntity<>(savedRegistration, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Registration registration = registrationService.getRegistrationById(id);
        if (registration != null) {
            return new ResponseEntity<>(registration, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getAllRegistrations();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Long id, @RequestBody Registration registrationDetails) {
        Registration registration = registrationService.getRegistrationById(id);
        if (registration != null) {
            registration.setEvent(registrationDetails.getEvent());
            registration.setUser(registrationDetails.getUser());

            Registration updatedRegistration = registrationService.saveRegistration(registration);
            return new ResponseEntity<>(updatedRegistration, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
