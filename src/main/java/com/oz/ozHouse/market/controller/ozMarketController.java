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
	public ModelAndView findProduct(@RequestParam("search") String search, HttpServletRequest req) {
		ModelAndView modelAndView = new ModelAndView("merchant/main/notice");
		modelAndView.addObject("listProduct", marketProService.findProduct(search));
		return modelAndView;
	}

	// 메인 상품 모아보기
	@GetMapping("")
	public String ozMarketMain(HttpServletRequest req, @RequestParam Map<String, Object> params) throws IOException {
		String root = PATH + "\\" + "img";
		req.setAttribute("proImg", root);

		List<OzMarketProDTO> list = marketProService.listProduct(params);
		for (OzMarketProDTO dto : list) {
			String[] imageFiles = dto.getProImageChange().split(",");
			if (imageFiles.length > 0) {
				File imageFile = new File(root, imageFiles[0]);
				if (imageFile.exists()) {
					String encodedImage = encodeImageToBase64(imageFile);
					dto.setEncodedImage(encodedImage);
				}
			}
		}
		req.setAttribute("listProduct", list);
		return "client/ozMarket/ozMarket";
	}

	// 물건 팔기 폼
	@GetMapping("/my-product")
	public String ozMarketMyProduct(HttpServletRequest req) {
		return "client/ozMarket/myProduct_input";
	}

	// 물건 팔기 등록
	@PostMapping("/my-product")
	public String ozMarketMyProduct(@RequestParam("proImgPro") List<MultipartFile> proImgPro, HttpServletRequest req,
			@RequestParam Map<String, String> params) throws Exception {
		OzMarketProDTO dto = new OzMarketProDTO(req);
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

//		dto.setMemberNickname(memberNickname);

		String res = marketProService.insertProduct(dto);

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
	public String ozMarketContent(HttpServletRequest req, @PathVariable(value = "proNum") Integer proNum)
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
		System.out.println("닉네임 : " + member.getMemberNickname());
		req.setAttribute("nickname", member.getMemberNickname());
		return "client/ozMarket/myInfo";
	}

}
