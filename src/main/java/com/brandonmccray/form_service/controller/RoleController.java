package com.brandonmccray.form_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandonmccray.form_service.model.Role;
import com.brandonmccray.form_service.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }
  
  @GetMapping()
  public ResponseEntity<List<Role>> getAllRoles() {
    return ResponseEntity.ok(roleService.getAllRoles());
  }
}
