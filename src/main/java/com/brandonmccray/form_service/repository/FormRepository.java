package com.brandonmccray.form_service.repository;

import com.brandonmccray.form_service.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
  
}
