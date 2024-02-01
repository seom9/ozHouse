package com.oz.ozHouse.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oz.ozHouse.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	int num;
}
