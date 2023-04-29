package com.springs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springs.Exception.CustomerException;
import com.springs.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
