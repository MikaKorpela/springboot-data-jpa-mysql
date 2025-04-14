package com.pikecape.springboot.data.service;

import com.pikecape.springboot.data.model.Person;
import com.pikecape.springboot.data.model.Profession;
import com.pikecape.springboot.data.repository.PersonRepository;
import com.pikecape.springboot.data.repository.ProfessionRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;
  private final ProfessionRepository professionRepository;

  public List<Person> findAll() {
    return personRepository.findAll();
  }

  public Person findById(Integer id) {
    return personRepository.findById(id).orElse(null);
  }

  public Person create(Person person) {
    person.setCreatedAt(LocalDateTime.now());

    if (person.getAddress() != null) {
      person.getAddress().setCreatedAt(LocalDateTime.now());
    }

    return personRepository.save(person);
  }

  public Person addProfession(Integer id, Integer professionId) {
    Person person = personRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Person not found"));

    Profession profession = professionRepository.findById(professionId)
        .orElseThrow(() -> new RuntimeException("Profession not found"));

    //person.getProfessions().add(profession);
    person.setUpdatedAt(LocalDateTime.now());

    return personRepository.save(person);
  }

  public Person update(Integer id, Person person) {
    personRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Person not found"));

    person.setPersonId(id);
    person.setUpdatedAt(LocalDateTime.now());

    return personRepository.save(person);
  }

  public void deleteById(Integer id) {
    Person person = personRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Person not found"));

    personRepository.delete(person);
  }
}
