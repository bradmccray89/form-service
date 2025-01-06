package com.brandonmccray.form_service.service;

import com.brandonmccray.form_service.model.Form;
import com.brandonmccray.form_service.model.FormField;
import com.brandonmccray.form_service.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
  
  // save form and form fields
  public Form createForm(Form form) {
    System.out.println("CREATE FORM: " + form);
    if (form.getFormFields() != null) {
      form.getFormFields().forEach(formField -> formField.setForm(form));
    }
    return formRepository.save(form);
  }

  public Form updateForm(Long id, Form formDetails) {
    System.out.println("UPDATE FORM: " + id);
    Form form = getFormById(id);
    form.setTitle(formDetails.getTitle());
    form.setDescription(formDetails.getDescription());
    form.setIsActive(formDetails.getIsActive());

    List<FormField> updatedFormFields = formDetails.getFormFields();
    if (updatedFormFields != null) {
      form.getFormFields().clear();

      for (FormField formField : updatedFormFields) {
        formField.setForm(form);
        form.getFormFields().add(formField);
      }
    }

    return formRepository.save(form);
  }

  public void deleteForm(Long id) {
    formRepository.deleteById(id);
  }
}
