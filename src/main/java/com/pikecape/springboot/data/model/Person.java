package com.pikecape.springboot.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer personId;
  String name;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
  @JoinColumn(
      name = "address_id", // this is the column in the ducks table
      referencedColumnName = "addressId", // this is the attribute in address object
      nullable = true // this tells if the relationship can be null
  )
  Address address;

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employer.class)
  @JoinColumn(name = "employer_id", referencedColumnName = "employerId", nullable = true)
  @JsonBackReference
  Employer employer;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinTable(name = "persons_professions",
      joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "personId")},
      inverseJoinColumns = {@JoinColumn(name = "profession_id", referencedColumnName = "professionId")}
  )
  @JsonManagedReference
  private Set<Profession> professions = new HashSet<>();

  LocalDateTime createdAt;
  LocalDateTime updatedAt;

  @Override
  public int hashCode() {
    return Objects.hash(personId); // Use only the primary key
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Person person = (Person) obj;
    return Objects.equals(personId, person.personId); // Compare only the primary key
  }
}
