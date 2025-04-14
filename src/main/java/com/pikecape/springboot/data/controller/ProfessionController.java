package com.pikecape.springboot.data.controller;

import com.pikecape.springboot.data.model.Profession;
import com.pikecape.springboot.data.service.ProfessionService;
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
@RequestMapping("/api/professions")
@RequiredArgsConstructor
public class ProfessionController {
  private final ProfessionService professionService;

  @GetMapping
  public List<Profession> findAll() {
    return professionService.findAll();
  }

  @GetMapping("/{id}")
  public Profession findById(
      @PathVariable Integer id
  ) {
    return professionService.findById(id);
  }

  @PostMapping
  public Profession create(
      @RequestBody Profession profession
  ) {
    return professionService.create(profession);
  }

  @PutMapping("/{id}")
  public Profession update(
      @PathVariable Integer id,
      @RequestBody Profession profession
  ) {
    return professionService.update(id, profession);
  }

  @DeleteMapping("/{id}")
  public void delete(
      @PathVariable Integer id
  ) {
    professionService.deleteById(id);
  }
}
