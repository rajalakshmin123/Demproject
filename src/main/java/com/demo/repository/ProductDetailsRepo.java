package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.ProductDetails;

public interface ProductDetailsRepo extends JpaRepository<ProductDetails, String> {

	@Query(value = "select * from nintriva.product p where p.product_name like %:search%", nativeQuery = true)
	 List<ProductDetails> findByKeyword(@Param("search") String search);
	
	@Query(value = "select * from nintriva.product p where id=?1", nativeQuery = true)
	 ProductDetails findById(@Param("id") int id);
}
