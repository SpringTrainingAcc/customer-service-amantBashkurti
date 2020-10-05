package com.customer.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;
import com.customer.ms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<CustomerM> findAll(){
		return customerRepository.findAll();
	}

	@Override
	public CustomerM findById(String cusId) {
		Optional<CustomerM> opt = customerRepository.findById(cusId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public CustomerM addCustomer(CustomerM customerm) {
		return customerRepository.save(customerm);
	}
	
	@Override
	public CustomerM updateCustomer(CustomerM customerm) {
		return customerRepository.save(customerm);
	}
	
	@Override
	public void deleteCustomer(String cusId) {
		customerRepository.deleteById(cusId);
	}
	
}
