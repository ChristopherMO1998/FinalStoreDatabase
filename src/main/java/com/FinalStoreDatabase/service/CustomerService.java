package com.FinalStoreDatabase.service;

import java.util.List;

import com.FinalStoreDatabase.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);

	public List<Customer> getByKeyword(String keyword);

	public List<Customer> findAllReverse();

}
