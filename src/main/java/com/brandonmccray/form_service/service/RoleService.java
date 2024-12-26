package com.brandonmccray.form_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brandonmccray.form_service.model.Role;
import com.brandonmccray.form_service.repository.RoleRepository;

@Service
public class RoleService {
  private final RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public List<Role> getAllRoles() {
    return roleRepository.findAll();
  }

  public Role getRoleById(Long id) {
    return roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role Not Found!"));
  }
  
  public Role createRole(Role role) {
    return roleRepository.save(role);
  }

  public Role updateRole(Long id, Role roleDetails) {
    Role role = getRoleById(id);
    role.setName(roleDetails.getName());
    role.setDescription(roleDetails.getDescription());
    return roleRepository.save(role);
  }

  public void deleteRole(Long id) {
    roleRepository.deleteById(id);
  }
}
