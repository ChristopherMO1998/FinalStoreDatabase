package com.FinalStoreDatabase.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FinalStoreDatabase.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findAllByOrderByLastNameAsc();

	public List<Customer> findAllByOrderByLastNameDesc();

	@Query(value = "SELECT * FROM storedatabase.customer" + " WHERE first_name like %:keyword% or "
			+ "last_name like %:keyword% or address like %:keyword% or state like %:keyword%", nativeQuery = true)
	public List<Customer> findByKeyword(@Param("keyword") String keyword);
}
