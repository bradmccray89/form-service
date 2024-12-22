package com.brandonmccray.form_service.service;

import com.brandonmccray.form_service.model.Form;
import com.brandonmccray.form_service.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public class FormService {
  private final FormRepository formRepository;

  public FormService(FormRepository formRepository) {
    this.formRepository = formRepository;
  }

  public List<Form> getAllForms() {
    return formRepository.findAll();
  }

  public Form getFormById(Long id) {
    return formRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Form Not Found!"));
  }
  
  public Form createForm(Form form) {
    return formRepository.save(form);
  }

  public Form updateForm(Long id, Form formDetails) {
    Form form = getFormById(id);
    form.setTitle(formDetails.getTitle());
    form.setDescription(formDetails.getDescription());
    form.setFields(formDetails.getFields());
    return formRepository.save(form);
  }

  public void deleteForm(Long id) {
    formRepository.deleteById(id);
  }
}
