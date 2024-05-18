package pl.ems.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ems.ems.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
