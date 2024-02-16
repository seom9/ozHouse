package com.oz.ozHouse.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.repository.CliProductRepository;
import com.oz.ozHouse.repository.CliProductRepositoryImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CliProductServiceImpl implements CliProductService{
	private final CliProductRepository pr;

	@Override
	public List<Product> cliProductList() {
		return pr.findAll();
	}
}
