package pl.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ems.ems.model.Employee;
import pl.ems.ems.model.Event;
import pl.ems.ems.model.EventApproval;

import java.util.List;

@Repository
public interface EventApprovalRepository extends JpaRepository<EventApproval, Long> {
    List<EventApproval> findByEvent(Event event);
    List<EventApproval> findByEmployee(Employee employee);
}
