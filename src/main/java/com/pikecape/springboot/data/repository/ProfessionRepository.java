package com.pikecape.springboot.data.repository;

import com.pikecape.springboot.data.model.Person;
import com.pikecape.springboot.data.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {}
