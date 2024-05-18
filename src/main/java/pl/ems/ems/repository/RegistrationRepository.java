package pl.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ems.ems.model.Event;
import pl.ems.ems.model.Registration;
import pl.ems.ems.model.User;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByEvent(Event event);
    List<Registration> findByUser(User user);
}