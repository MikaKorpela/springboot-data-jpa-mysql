package com.pikecape.springboot.data.service;

import com.pikecape.springboot.data.model.Address;
import com.pikecape.springboot.data.model.Employer;
import com.pikecape.springboot.data.model.Person;
import com.pikecape.springboot.data.repository.EmployerRepository;
import com.pikecape.springboot.data.repository.PersonRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerService {

  private final EmployerRepository employerRepository;
  private final PersonRepository personRepository;

  public List<Employer> findAll() {
    return employerRepository.findAll();
  }

  public Employer findById(Integer id) {
    return employerRepository.findById(id).orElse(null);
  }

  public Employer create(Employer employer) {
    employer.setCreatedAt(LocalDateTime.now());

    return employerRepository.save(employer);
  }

  public Employer addPersonToEmployment(Integer employerId, Integer personId) {
    Employer employer = employerRepository.findById(employerId)
        .orElseThrow(() -> new RuntimeException("Employer not found"));

    Person person = personRepository.findById(personId)
        .orElseThrow(() -> new RuntimeException("Duck not found"));

    person.setEmployer(employer);
    person.setUpdatedAt(LocalDateTime.now());

    personRepository.save(person);

    return employerRepository.findById(employerId)
        .orElseThrow(() -> new RuntimeException("Employer not found"));
  }

  public Employer update(Integer id, Employer employer) {
    employerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Address not found"));

    employer.setEmployerId(id);
    employer.setUpdatedAt(LocalDateTime.now());

    return employerRepository.save(employer);
  }

  public void deleteById(Integer id) {
    Employer employer = employerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employer not found"));

    employerRepository.delete(employer);
  }
}
