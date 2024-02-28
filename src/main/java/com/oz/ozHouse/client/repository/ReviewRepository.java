package com.oz.ozHouse.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	List<Review> findAll();
	
	long count();
}
