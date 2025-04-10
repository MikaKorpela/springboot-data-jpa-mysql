package com.pikecape.springboot.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Table(name = "ducks")
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder(toBuilder = true)
@Data
public class Duck {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;
  String uid;
  String name;

  LocalDateTime createdAt;
  LocalDateTime updatedAt;
}
