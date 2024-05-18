package pl.ems.ems.service;

import pl.ems.ems.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
