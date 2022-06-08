package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.CustomerDetails;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, String> {
	@Query(value = "select * from nintriva.customer;",
			  nativeQuery = true)
	List<CustomerDetails> findAll();
	
	@Query(value = "SELECT * FROM nintriva.customer u WHERE u.email =?1",
			  nativeQuery = true)
	CustomerDetails findUsersByemail(@Param("email") String usertype);


	//@Query(value="select password from nintriva.customer where")
}
