package com.brandonmccray.form_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brandonmccray.form_service.model.Form;
import com.brandonmccray.form_service.model.FormField;
import com.brandonmccray.form_service.repository.FormFieldRepository;
import com.brandonmccray.form_service.repository.FormRepository;

@Service
public class FormFieldService {
  private final FormFieldRepository formFieldRepository;
  private final FormRepository formRepository;

  public FormFieldService(FormFieldRepository formFieldRepository, FormRepository formRepository) {
    this.formFieldRepository = formFieldRepository;
    this.formRepository = formRepository;
  }

  public List<FormField> createFormFields(List<FormField> formFields) {
    return formFieldRepository.saveAll(formFields);
  }

  public List<FormField> createFormFieldsForForm(Long formId, List<FormField> formFields) {
    System.out.println("CREATE FORM FIELDS FOR FORM: " + formId);
    Form form = formRepository.findById(formId)
        .orElseThrow(() -> new RuntimeException("Form Not Found!"));
    formFields.forEach(formField -> formField.setForm(form));
    return formFieldRepository.saveAll(formFields);
  }

  public FormField updateFormField(Long id, FormField formFieldDetails) {
    FormField formField = formFieldRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Form Field Not Found!"));
    formField.setName(formFieldDetails.getName());
    formField.setDescription(formFieldDetails.getDescription());
    formField.setLabel(formFieldDetails.getLabel());
    formField.setInputType(formFieldDetails.getInputType());
    return formFieldRepository.save(formField);
  }

  public void deleteFormField(Long id) {
    formFieldRepository.deleteById(id);
  }
}
