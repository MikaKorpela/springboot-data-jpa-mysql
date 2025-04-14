package com.pikecape.springboot.data.controller;

import com.pikecape.springboot.data.model.Address;
import com.pikecape.springboot.data.model.Employer;
import com.pikecape.springboot.data.service.EmployerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employers")
@RequiredArgsConstructor
public class EmployerController {
  private final EmployerService employerService;

  @GetMapping
  public List<Employer> findAll() {
    return employerService.findAll();
  }

  @GetMapping("/{id}")
  public Employer findById(
      @PathVariable Integer id
  ) {
    return employerService.findById(id);
  }

  @PostMapping
  public Employer create(
      @RequestBody Employer employer
  ) {
    return employerService.create(employer);
  }

  @PutMapping("/{id}")
  public Employer update(
      @PathVariable Integer id,
      @RequestBody Employer employer
  ) {
    return employerService.update(id, employer);
  }

  @DeleteMapping("/{id}")
  public void delete(
      @PathVariable Integer id
  ) {
    employerService.deleteById(id);
  }
}
