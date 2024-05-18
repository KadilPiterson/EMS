package pl.ems.ems.service;

import pl.ems.ems.model.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    void deleteRole(Long id);
    Role getRoleById(Long id);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
}
