package com.FinalStoreDatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalStoreDatabase.dao.CustomerRepository;
import com.FinalStoreDatabase.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
		customerRepository = theCustomerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public List<Customer> findAllReverse() {
		return customerRepository.findAllByOrderByLastNameDesc();
	}

	@Override
	public List<Customer> getByKeyword(String keyword) {
		return customerRepository.findByKeyword(keyword);
	}

	@Override
	public Customer findById(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);

		Customer theCustomer = null;

		if (result.isPresent()) {
			theCustomer = result.get();
		} else {
			throw new RuntimeException("Did not find that customer");
		}
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}
}
