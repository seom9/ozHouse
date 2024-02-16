package com.oz.ozHouse.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CliProductRepositoryImpl {
	private final EntityManager em;
	
}
