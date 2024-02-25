package com.oz.ozHouse;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.client.service.BlogServiceImpl;
import com.oz.ozHouse.client.service.ProductService;
import com.oz.ozHouse.client.service.ProductServiceImpl;
import com.oz.ozHouse.client.service.EmailService;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.domain.Blog;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.BlogDTO;
import com.oz.ozHouse.dto.ProductDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class OzHouseController {
	
	private final ProductServiceImpl ps;
	private final BlogServiceImpl bs;
	
	@GetMapping(value = {"/", "/index", "/main"})
	public String index(Model model) {

		List<ProductDTO> cliProductList = ps.cliProductList();
		List<BlogDTO> blogList = bs.blogList();
		
		for(ProductDTO dto : cliProductList) {
			System.out.println("가격2 : " + dto.getProPrice());
		}
		
		for(BlogDTO dto : blogList) {
			System.out.println("블로그 번호 : " + dto.getBlogNum());
		}
		
		
		model.addAttribute("productList", cliProductList);
		model.addAttribute("blogList", blogList);
		
		return "client/main/Main";
	}
	
}