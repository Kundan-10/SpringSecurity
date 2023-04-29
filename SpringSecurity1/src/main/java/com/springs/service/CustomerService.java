package com.springs.service;

import java.util.List;
import com.springs.Exception.CustomerException;
import com.springs.model.Customer;


public interface CustomerService {
	
public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;

}
