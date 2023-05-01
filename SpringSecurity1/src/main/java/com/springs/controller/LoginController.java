package com.springs.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestController;

import com.springs.model.Customer;
import com.springs.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		 Customer customer= customerRepository.findByEmail(auth.name()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		 
		 return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
}
