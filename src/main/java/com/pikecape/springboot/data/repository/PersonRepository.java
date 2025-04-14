package com.pikecape.springboot.data.repository;

import com.pikecape.springboot.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {}
