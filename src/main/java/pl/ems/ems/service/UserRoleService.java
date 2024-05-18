package pl.ems.ems.service;

import pl.ems.ems.model.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole saveUserRole(UserRole userRole);
    void deleteUserRole(Long id);
    UserRole getUserRoleById(Long id);
    List<UserRole> getAllUserRoles();
}
