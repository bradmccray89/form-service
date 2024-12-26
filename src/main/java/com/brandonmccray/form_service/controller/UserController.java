package com.brandonmccray.form_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandonmccray.form_service.model.User;
import com.brandonmccray.form_service.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping()
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
    return ResponseEntity.ok(userService.getUserByUsername(username));
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    return ResponseEntity.ok(userService.getUserByEmail(email));
  }

  @GetMapping("/username/{username}/email/{email}")
  public ResponseEntity<User> getUserByUsernameAndEmail(@PathVariable String username, @PathVariable String email) {
    User user = userService.getUserByUsername(username);
    if (user.getEmail().equals(email)) {
      return ResponseEntity.ok(user);
    } else {
      throw new RuntimeException("User Not Found!");
    }
  }

  @PostMapping()
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.createUser(user));
  }

  @PostMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    return ResponseEntity.ok(userService.updateUser(id, user));
  }

  @PostMapping("/{id}/role/{roleId}/add")
  public ResponseEntity<Void> addRoleToUser(@PathVariable Long id, @PathVariable Long roleId) {
    userService.addRoleToUser(id, roleId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{id}/role/{roleId}/remove")
  public ResponseEntity<Void> removeRoleFromUser(@PathVariable Long id, @PathVariable Long roleId) {
    userService.removeRoleFromUser(id, roleId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{id}/delete")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }  
}
