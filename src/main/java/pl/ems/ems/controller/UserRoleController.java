package pl.ems.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ems.ems.model.UserRole;
import pl.ems.ems.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole userRole) {
        UserRole savedUserRole = userRoleService.saveUserRole(userRole);
        return new ResponseEntity<>(savedUserRole, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long id) {
        UserRole userRole = userRoleService.getUserRoleById(id);
        if (userRole != null) {
            return new ResponseEntity<>(userRole, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserRole>> getAllUserRoles() {
        List<UserRole> userRoles = userRoleService.getAllUserRoles();
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateUserRole(@PathVariable Long id, @RequestBody UserRole userRoleDetails) {
        UserRole userRole = userRoleService.getUserRoleById(id);
        if (userRole != null) {
            userRole.setUser(userRoleDetails.getUser());
            userRole.setRole(userRoleDetails.getRole());

            UserRole updatedUserRole = userRoleService.saveUserRole(userRole);
            return new ResponseEntity<>(updatedUserRole, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
