package com.FinalStoreDatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalStoreDatabase.dao.ProductRepository;
import com.FinalStoreDatabase.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository theProductRepository) {
		productRepository = theProductRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAllByOrderByProductNameAsc();
	}

	@Override
	public List<Product> getByKeyword(String keyword) {
		return productRepository.findByKeyword(keyword);
	}

	@Override
	public Product findById(int theId) {
		Optional<Product> result = productRepository.findById(theId);

		Product theProduct = null;

		if (result.isPresent()) {
			theProduct = result.get();
		} else {
			throw new RuntimeException("Did not find that product");
		}
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		productRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}
}
