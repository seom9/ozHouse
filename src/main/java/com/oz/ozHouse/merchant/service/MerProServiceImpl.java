package com.oz.ozHouse.merchant.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;
import com.oz.ozHouse.repository.ProductRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //의존성 주입
public class MerProServiceImpl implements MerProService {
	
	private final MerProductRepository proRepository;

	@Override
	public String insertProduct(ProductDTO dto) {
		Product pro = new Product(dto);
		System.out.println("service : " + dto.getProName());
		System.out.println(pro.getProName());
		proRepository.save(pro);
		return dto.getProName();
	}


}
