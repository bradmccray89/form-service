package com.brandonmccray.form_service.repository;

import com.brandonmccray.form_service.model.FormField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldRepository extends JpaRepository<FormField, Long> {
  
}
