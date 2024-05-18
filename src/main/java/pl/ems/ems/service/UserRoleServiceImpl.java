package pl.ems.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ems.ems.model.UserRole;
import pl.ems.ems.repository.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        Optional<UserRole> userRole = userRoleRepository.findById(id);
        return userRole.orElse(null);
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }
}
