package com.brandonmccray.form_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandonmccray.form_service.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(String name);
}
