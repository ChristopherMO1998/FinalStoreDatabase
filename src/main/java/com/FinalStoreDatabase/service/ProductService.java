package com.FinalStoreDatabase.service;

import java.util.List;

import com.FinalStoreDatabase.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product findById(int theId);

	public void save(Product theProduct);

	public void deleteById(int theId);

	public List<Product> getByKeyword(String keyword);
}
