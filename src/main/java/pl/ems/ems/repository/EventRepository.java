package pl.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ems.ems.model.Event;
import pl.ems.ems.model.User;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStatus(String status);
    List<Event> findByCreatedBy(User user);
    List<Event> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
}
