package com.brandonmccray.form_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brandonmccray.form_service.model.Role;
import com.brandonmccray.form_service.model.User;
import com.brandonmccray.form_service.repository.UserRepository;
import com.brandonmccray.form_service.service.RoleService;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User Not Found!"));
  }

  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User Not Found!"));
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User Not Found!"));
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(Long id, User userDetails) {
    User user = getUserById(id);
    user.setUsername(userDetails.getUsername());
    user.setPassword(userDetails.getPassword());
    user.setEmail(userDetails.getEmail());
    user.setRoles(userDetails.getRoles());
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  public void addRoleToUser(Long userId, Long roleId) {
    User user = getUserById(userId);
    RoleService roleService = new RoleService(null);
    Role role = roleService.getRoleById(roleId);
    user.getRoles().add(role);
    userRepository.save(user);
  }

  public void removeRoleFromUser(Long userId, Long roleId) {
    User user = getUserById(userId);
    RoleService roleService = new RoleService(null);
    Role role = roleService.getRoleById(roleId);
    user.getRoles().remove(role);
    userRepository.save(user);
  }
}
