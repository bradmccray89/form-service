package com.brandonmccray.form_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandonmccray.form_service.model.FormField;
import com.brandonmccray.form_service.service.FormFieldService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/form-fields")
public class FormFieldController {
  private final FormFieldService formFieldService;

  public FormFieldController(FormFieldService formFieldService) {
    this.formFieldService = formFieldService;
  }

  @PostMapping("/{id}")
  public ResponseEntity<List<FormField>> createFormFieldsForForm(@PathVariable Long id, @RequestBody List<FormField> formFields) {
    return ResponseEntity.ok(formFieldService.createFormFieldsForForm(id, formFields));
  }
}
