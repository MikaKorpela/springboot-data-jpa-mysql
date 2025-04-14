package com.pikecape.springboot.data.repository;

import com.pikecape.springboot.data.model.Address;
import com.pikecape.springboot.data.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {}
