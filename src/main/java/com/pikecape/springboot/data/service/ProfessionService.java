package com.pikecape.springboot.data.service;

import com.pikecape.springboot.data.model.Profession;
import com.pikecape.springboot.data.model.Profession;
import com.pikecape.springboot.data.repository.ProfessionRepository;
import com.pikecape.springboot.data.repository.ProfessionRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessionService {

  private final ProfessionRepository professionRepository;

  public List<Profession> findAll() {
    return professionRepository.findAll();
  }

  public Profession findById(Integer id) {
    return professionRepository.findById(id).orElse(null);
  }

  public Profession create(Profession profession) {
    profession.setCreatedAt(LocalDateTime.now());

    return professionRepository.save(profession);
  }

  public Profession update(Integer id, Profession profession) {
    professionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Profession not found"));

    profession.setProfessionId(id);
    profession.setUpdatedAt(LocalDateTime.now());

    return professionRepository.save(profession);
  }

  public void deleteById(Integer id) {
    Profession profession = professionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Profession not found"));

    professionRepository.delete(profession);
  }
}
