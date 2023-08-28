package com.recell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recell.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}