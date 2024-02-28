package com.oz.ozHouse.client.controller.shopping;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.AwsS3Service;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.client.service.ProductServiceImpl;
import com.oz.ozHouse.client.service.ReivewServiceImpl;
import com.oz.ozHouse.client.service.ScrapService;
import com.oz.ozHouse.dto.BlogDTO;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.ReviewDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@Validated
@RequiredArgsConstructor
public class ShoppingController {
	
	private final ProductServiceImpl ps;
	private final ScrapService scrapService;
	private final MemberService memberService;
	private final ReivewServiceImpl rs;
	private static final String PATH = "D:\\imageFiles";
	private final AwsS3Service aws;
	
	@GetMapping(value = "{proNum}/prodView")
	public String prodView(@AuthenticationPrincipal MemberSecurityDTO member,
								@PathVariable("proNum") int proNum, Model model) {
		
		ProductDTO productDTO = ps.getProduct(proNum);
		
		String memberId = (member != null) ? member.getUsername() : null;
		
		// 가현 : 스크랩 추가
		if (member != null) {
			productDTO.setScrap(scrapService.isScrap(member.getUsername(), proNum) 
					? true : false);
		}
		
		List<ReviewDTO> reviewList = rs.reivewList();
		
		long res = rs.reviewCount();

		model.addAttribute("productDTO", productDTO);
		model.addAttribute("loginMember", memberId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewCount", res);
		
		return "client/main/Prodview";
	}
	
	@GetMapping(value = "products")
	public String goProducts(@AuthenticationPrincipal MemberSecurityDTO member, Model model) {
		
		String memberId = (member != null) ? member.getUsername() : null;

		List<ProductDTO> cliProductList = ps.cliProductList(memberId);
		
		model.addAttribute("product", cliProductList);
		model.addAttribute("spec", "products");
		
		return "client/main/products";
	}
	
	@GetMapping(value = "products/today")
	public String goProductsToday(@AuthenticationPrincipal MemberSecurityDTO member,
								Model model) {
		
		String memberId = (member != null) ? member.getUsername() : null;

		List<ProductDTO> cliProductList = ps.todayProductList(memberId);
		
		model.addAttribute("product", cliProductList);
		model.addAttribute("spec", "today");
		
		return "client/main/products";
	}
	
	@PostMapping(value = "{proNum}/review")
	public String reviewWrite(@PathVariable("proNum") int proNum, HttpServletRequest req,
			@ModelAttribute ReviewDTO dto, BindingResult result,
			@RequestParam(name = "reviewContent") String reviewContent) {
		System.out.println("리뷰 컨트롤러 실행");
    	
		if(result.hasErrors()) {
    		dto.setReviewImage("");
    	}
    	
    	String root = PATH + "\\" + "reviewImages";
    	
    	File fileCheck = new File(root);
    	if(!fileCheck.exists()) fileCheck.mkdir();
    	
    	MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
    	MultipartFile mf = mr.getFile("reviewImage");
    	
    	String fileName = aws.uploadImg(mf);
    	
	    LocalDate currentDate = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
	    String formattedDate = currentDate.format(formatter);
    	
    	dto.setReviewImage(fileName);
    	dto.setProductNum(proNum);
    	dto.setReviewContent(reviewContent);
    	dto.setReviewDate(formattedDate);
    	
		
		int res = rs.insertReview(dto);
		if(res > 0) {
			req.setAttribute("msg", "리뷰 등록 성공");
			req.setAttribute("url", proNum + "/prodView");
		} else {
			req.setAttribute("msg", "리뷰 등록 실패");
			req.setAttribute("url", proNum + "/prodView");
		}
		
		return "message";
	}
}