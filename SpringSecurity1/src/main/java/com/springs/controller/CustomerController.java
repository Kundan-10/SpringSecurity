package com.springs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springs.Exception.CustomerException;
import com.springs.model.Customer;
import com.springs.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String testHandler() {
		
		return "Welcome to Spring Secutity";
		
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer registeredCustomer= customerService.registerCustomer(customer);
		return new ResponseEntity<>(registeredCustomer, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerDetailsByEmail(@PathVariable("email") String email) throws CustomerException{
		Customer customer=customerService.getCustomerDetailsByEmail(email);
		return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<List<Customer>>getAllCustomerHander() throws CustomerException{
		List<Customer> customer=customerService.getAllCustomerDetails();
		return new ResponseEntity<List<Customer>>(customer,HttpStatus.ACCEPTED);
	}

}
