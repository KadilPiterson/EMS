package pl.ems.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ems.ems.model.Registration;
import pl.ems.ems.repository.RegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public Registration getRegistrationById(Long id) {
        Optional<Registration> registration = registrationRepository.findById(id);
        return registration.orElse(null);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
}
