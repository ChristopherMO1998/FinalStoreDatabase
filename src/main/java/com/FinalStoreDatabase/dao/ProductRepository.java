package com.FinalStoreDatabase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FinalStoreDatabase.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findAllByOrderByProductNameAsc();

	@Query(value = "SELECT * FROM storedatabase.product" + " WHERE product_name like %:keyword% or "
			+ "product_price like %:keyword% or product_desc like %:keyword%", nativeQuery = true)
	public List<Product> findByKeyword(@Param("keyword") String keyword);
}
