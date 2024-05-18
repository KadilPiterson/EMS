package pl.ems.ems.service;

import pl.ems.ems.model.Registration;

import java.util.List;

public interface RegistrationService {
    Registration saveRegistration(Registration registration);
    void deleteRegistration(Long id);
    Registration getRegistrationById(Long id);
    List<Registration> getAllRegistrations();
}
