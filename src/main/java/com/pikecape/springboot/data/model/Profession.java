package com.pikecape.springboot.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Profession {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer professionId;
  String name;

  @ManyToMany(mappedBy = "professions", fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
  @JsonBackReference
  private Set<Person> persons = new HashSet<>();

  LocalDateTime createdAt;
  LocalDateTime updatedAt;
}
