package com.pikecape.springboot.data.service;

import com.pikecape.springboot.data.model.Duck;
import com.pikecape.springboot.data.repository.DuckRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuckService {

  private final DuckRepository duckRepository;

  public List<Duck> getDucks() {
    return StreamSupport.stream(duckRepository.findAll().spliterator(), false)
        .toList();
  }

  public Duck getDuck(String uid) {
    return duckRepository.findByUid(uid);
  }

  public Duck createDuck(Duck duck) {
    if (duck.getUid() == null || duck.getUid().isBlank()) {
      duck.setUid(UUID.randomUUID().toString());
    }

    duck.setCreatedAt(LocalDateTime.now());

    return duckRepository.save(duck);
  }

  public Duck updateDuck(String uid, Duck duck) {
    Optional.ofNullable(duckRepository.findByUid(uid))
        .orElseThrow(() -> new RuntimeException("Duck not found"));

    duck.setUid(uid);
    duck.setUpdatedAt(LocalDateTime.now());

    return duckRepository.save(duck);
  }

  public void deleteDuck(String uid) {
    Duck duck = Optional.ofNullable(duckRepository.findByUid(uid))
        .orElseThrow(() -> new RuntimeException("Duck not found"));

    duckRepository.delete(duck);
  }
}
