package com.pikecape.springboot.data.controller;

import com.pikecape.springboot.data.model.Person;
import com.pikecape.springboot.data.service.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
  private final PersonService personService;

  @GetMapping
  public List<Person> findAll() {
    return personService.findAll();
  }

  @GetMapping("/{id}")
  public Person findById(
      @PathVariable Integer id
  ) {
    return personService.findById(id);
  }

  @PostMapping
  public Person create(
      @RequestBody Person person
  ) {
    return personService.create(person);
  }

  @PostMapping("/{id}/professions")
  public Person addProfession(
      @PathVariable Integer id,
      @RequestParam Integer professionId
  ) {
    return personService.addProfession(id, professionId);
  }

  @PutMapping("/{id}")
  public Person update(
      @PathVariable Integer id,
      @RequestBody Person person
  ) {
    return personService.update(id, person);
  }

  @DeleteMapping("/{id}")
  public void delete(
      @PathVariable Integer id
  ) {
    personService.deleteById(id);
  }
}
