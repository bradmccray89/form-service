package com.brandonmccray.form_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.brandonmccray.form_service.model.Form;
import com.brandonmccray.form_service.service.FormService;

import java.util.List;

@RestController
@RequestMapping("/api/forms")
@CrossOrigin(origins = "*")
public class FormController {
  private final FormService formService;

  public FormController(FormService formService) {
    this.formService = formService;
  }

  @GetMapping()
  public ResponseEntity<List<Form>> getAllForms() {
    return ResponseEntity.ok(formService.getAllForms());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Form> getFormById(@PathVariable Long id) {
    return ResponseEntity.ok(formService.getFormById(id));
  }

  @PostMapping()
  public ResponseEntity<Form> createForm(@RequestBody Form form) {
    return ResponseEntity.ok(formService.createForm(form));
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Form> updateForm(@PathVariable Long id, @RequestBody Form form) {
    return ResponseEntity.ok(formService.updateForm(id, form));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteForm(@PathVariable Long id) {
    formService.deleteForm(id);
    return ResponseEntity.noContent().build();
  }
}
