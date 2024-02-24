package com.oz.ozHouse.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.client.service.MemberService;
import com.oz.ozHouse.domain.OzMarketPro;
import com.oz.ozHouse.dto.OzMarketProDTO;
import com.oz.ozHouse.market.service.MarketProService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ozMarket")
public class ozMarketController {

	private final MarketProService marketProService;
	
	private static final String PATH = "C:\\ozMarket\\";

	// base64 인코딩
	private String encodeImageToBase64(File file) throws IOException {

		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// 파일의 크기만큼 바이트 배열을 생성
			byte[] imageData = new byte[(int) file.length()];

			// 파일 내용을 읽어서 바이트 배열에 저장
			imageInFile.read(imageData);

			// 바이트 배열을 Base64 문자열로 인코딩
			return Base64.getEncoder().encodeToString(imageData);
		}
	}

	// 상품 검색
	@GetMapping("/search")
	public String findProduct(@RequestParam("search") String search, HttpServletRequest req) throws IOException {
		String root = PATH + "\\" + "img";
	    req.setAttribute("proImg", root);
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("limit", "search");
	    List<OzMarketProDTO> list = marketProService.findProduct(search);
	    for (OzMarketProDTO dto : list) {
	        // 이미지 처리
	        String[] imageFiles = dto.getProImageChange().split(",");
	        if (imageFiles.length > 0) {
	            File imageFile = new File(root, imageFiles[0]);
	            if (imageFile.exists()) {
	                // 이미지를 Base64로 인코딩
	                String encodedImage = encodeImageToBase64(imageFile);
	                dto.setEncodedImage(encodedImage);
	            }
	        }
	    }
	    // 상품 목록을 요청 속성에 추가
	    req.setAttribute("listProduct", list);
	    req.setAttribute("limit", 5);
	    return "client/ozMarket/ozMarket";
	}

	// 메인 페이지 최신 상품 9개 보기
	@GetMapping("")
	public String ozMarketMain(HttpServletRequest req) throws IOException {
	    String root = PATH + "\\" + "img";
	    req.setAttribute("proImg", root);

	    // 메인 페이지에 보여질 최신 상품 9개를 위한 'limit' 설정
	    Map<String, Object> params = new HashMap<>();
	    params.put("limit", 9);
	    List<OzMarketProDTO> list = marketProService.listProduct(params);
	    for (OzMarketProDTO dto : list) {
	        // 이미지 처리
	        String[] imageFiles = dto.getProImageChange().split(",");
	        if (imageFiles.length > 0) {
	            File imageFile = new File(root, imageFiles[0]);
	            if (imageFile.exists()) {
	                // 이미지를 Base64로 인코딩
	                String encodedImage = encodeImageToBase64(imageFile);
	                dto.setEncodedImage(encodedImage);
	            }
	        }
	    }
	    // 상품 목록을 요청 속성에 추가
	    req.setAttribute("listProduct", list);
	    req.setAttribute("limit", 9);
	    return "client/ozMarket/ozMarket";
	}

	// 모든 상품 보기 페이지
	@GetMapping("/products")
	public String ozMarkets(HttpServletRequest req) throws IOException {
	    String root = PATH + "\\" + "img";
	    req.setAttribute("proImg", root);

	    // 'params'에 'limit' 파라미터를 설정하지 않아 모든 상품을 조회
	    Map<String, Object> params = new HashMap<>();
	    List<OzMarketProDTO> list = marketProService.listProduct(params);
	    for (OzMarketProDTO dto : list) {
	        // 이미지 처리
	        String[] imageFiles = dto.getProImageChange().split(",");
	        if (imageFiles.length > 0) {
	            File imageFile = new File(root, imageFiles[0]);
	            if (imageFile.exists()) {
	                // 이미지를 Base64로 인코딩
	                String encodedImage = encodeImageToBase64(imageFile);
	                dto.setEncodedImage(encodedImage);
	            }
	        }
	    }
	    // 상품 목록을 요청 속성에 추가
	    req.setAttribute("listProduct", list);
	    req.setAttribute("limit", 0);
	    return "client/ozMarket/ozMarket";
	}

	// 물건 팔기 폼
	@GetMapping("/my-product")
	public String ozMarketMyProduct(@AuthenticationPrincipal MemberSecurityDTO member, HttpServletRequest req) {
		if (member == null) {
			req.setAttribute("msg", "로그인 후 이용가능합니다.");
			req.setAttribute("url", "/main");
			return "message";
		}
		return "client/ozMarket/myProduct_input";
	}

	// 물건 팔기 등록
	@PostMapping("/my-product")
	public String ozMarketMyProduct(@AuthenticationPrincipal MemberSecurityDTO member, @RequestParam("proImgPro") List<MultipartFile> proImgPro, HttpServletRequest req,
			@RequestParam Map<String, String> params) throws Exception {
		
		if (member != null) {
	        System.out.println("Member 객체가 null이 아닙니다. 닉네임: " + member.getMemberNickname());
	    } else {
	        System.out.println("Member 객체가 null입니다.");
	    }
		
		OzMarketProDTO dto = new OzMarketProDTO(req);
		
		if (member != null && member.getMemberNickname() != null) {
	        dto.setMemberNickname(member.getMemberNickname());
	        System.out.println("닉네임 설정: " + member.getMemberNickname()); // 닉네임이 설정되었는지 확인하기 위한 디버깅 라인
	    } else {
	        System.out.println("Member 또는 닉네임이 null입니다. DTO에 닉네임을 설정할 수 없습니다.");
	        // member가 null이거나 닉네임이 사용가능하지 않은 경우를 처리
	    }
		
		String nickName = member.getMemberNickname();
		dto.setMemberNickname(nickName);
		System.out.println("판매자 : " + dto.getMemberNickname());
		// 대표 이미지 폴더 지정
		String root = PATH + "\\" + "img";
		File fileCheck = new File(root);
		if (!fileCheck.exists())
			fileCheck.mkdir();

		List<Map<String, String>> fileList = new ArrayList<>();
		String fileproOri = "";
		for (int i = 0; i < proImgPro.size(); i++) {
			String originFile = proImgPro.get(i).getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString() + ext;
			Map<String, String> map = new HashMap<>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);
			fileproOri += originFile;
			fileList.add(map);
		}
		String filepro = "";

		try {
			for (int i = 0; i < proImgPro.size(); i++) {
				File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
				proImgPro.get(i).transferTo(uploadFile);
				System.out.println(uploadFile);
				filepro += fileList.get(i).get(("changeFile")) + ",";
			}

			System.out.println("다중 파일 업로드 성공");

		} catch (IllegalStateException | IOException e) {
			System.out.println("다중 파일 업로드 실패");
			for (int i = 0; i < proImgPro.size(); i++) {
				new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}

		dto.setProImageChange(filepro);
		dto.setProImgPro(fileproOri);
		
	    System.out.println("삽입 전 DTO 닉네임: " + dto.getMemberNickname());

		dto.setMemberNickname(member.getMemberNickname());
		String res = marketProService.insertProduct(dto);

	    System.out.println("삽입 후 DTO 닉네임: " + dto.getMemberNickname());

		if (res != null) {
			req.setAttribute("msg", "등록 성공했습니다.");
			// 경로 상세보기로 수정하기
			req.setAttribute("url", "/ozMarket");
//			req.setAttribute("url", "/ozMarket/my-product/" + Integer.parseInt(req.getParameter("proNum")));
		} else {
			req.setAttribute("msg", "등록 실패했습니다. 다시 시도하세요.");
			req.setAttribute("url", "/ozMarket/my-product");
		}
		return "message";
	}

	// 상세보기
	@GetMapping("/my-product/{proNum}")
	public String ozMarketContent(HttpServletRequest req, @PathVariable(value = "proNum") Integer proNum, @AuthenticationPrincipal MemberSecurityDTO member)
			throws IOException {
		String root = PATH + "\\" + "img";
		Optional<OzMarketProDTO> optionalDto = Optional.of(marketProService.getProduct(proNum));

		if (optionalDto.isPresent()) {
			OzMarketProDTO dto = optionalDto.get();
			req.setAttribute("getProduct", dto);

			List<String> encodedImagesPro = new ArrayList<>();
			String[] imageProFiles = dto.getProImageChange().split(",");
			for (String imageFileName : imageProFiles) {
				File imageProFile = new File(root, imageFileName);
				if (imageProFile.exists()) {
					String encodedImagePro = encodeImageToBase64(imageProFile);
					encodedImagesPro.add(encodedImagePro);
				}
			}
			req.setAttribute("encodedImagesPro", encodedImagesPro);

		}
		
		return "client/ozMarket/myProduct_content";
	}
	
	//내정보
	@GetMapping("/myInfo")
	public String ozMarketMyInfo(@AuthenticationPrincipal MemberSecurityDTO member, HttpServletRequest req) {
		if (member == null) {
			req.setAttribute("msg", "로그인 후 이용가능합니다.");
			req.setAttribute("url", "/main");
			return "message";
		}
		
		System.out.println("닉네임 : " + member.getMemberNickname());
		req.setAttribute("nickname", member.getMemberNickname());
		return "client/ozMarket/myInfo";
	}

}
