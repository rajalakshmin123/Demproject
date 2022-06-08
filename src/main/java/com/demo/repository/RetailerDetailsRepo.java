package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.RetailerDetails;

public interface RetailerDetailsRepo extends JpaRepository<RetailerDetails, String> {
	@Query(value = "select * from nintriva.retailer;",
			  nativeQuery = true)
	List<RetailerDetails> findAll();
	
	@Query(value = "SELECT * FROM nintriva.retailer u WHERE u.email =?1",
			  nativeQuery = true)
	RetailerDetails findRetailersByemail(@Param("email") String email);
}
