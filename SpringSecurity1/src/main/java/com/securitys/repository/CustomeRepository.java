package com.securitys.repository;

import java.util.Optional;

import com.springs.model.Customer;

public interface CustomeRepository {
	
	public Optional<Customer> findByEmail(String email);

}
