package com.pikecape.springboot.data.repository;

import com.pikecape.springboot.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {}
