package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.service.AwsS3Service;
import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.dto.RequestProductDTO;
import com.oz.ozHouse.merchant.service.MerProService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant")
public class MerProController {

	private final MerProService proService;
	private final AwsS3Service aws;
	static final String BUSINESSFILEPATH = 
			"C:\\nam\\SpringBoot\\ozHouse\\src\\main\\resources\\static\\merchant\\business";

	private static final String PATH = "D:\\imageFiles"; 

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

	// 상품 등록
	@GetMapping("/{merNum}/store/product-input")
	public String proInput(HttpServletRequest req, @PathVariable(value = "merNum") Integer merNum) {
		// 입점 신청시 등록한 카테고리 연동하기
		req.setAttribute("categories", Category.values());
		System.out.println("등록 폼");
		System.out.println("merNum : " + merNum);
		return "merchant/store/productManagement/productManagement_input";
	}

	@PostMapping("/{merNum}/store/product-input")
	public String proInput(@RequestParam("proImg") List<MultipartFile> proImg,
			@RequestParam("proImgPro") List<MultipartFile> proImgPro, HttpServletRequest req,
			@RequestParam Map<String, String> params, @PathVariable(value = "merNum") Integer merNum) throws Exception {

		ProductDTO dto = new ProductDTO(req);

		// 대표 이미지 폴더 지정
		String root = PATH + "\\" + "productImges";

		File fileCheck = new File(root);
		if (!fileCheck.exists())
			fileCheck.mkdir();

		// 상세 이미지 폴더 지정
		String root1 = PATH + "\\" + "productImgespro";

		File fileCheck1 = new File(root1);
		if (!fileCheck1.exists())
			fileCheck1.mkdir();

		// 대표 이미지
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
		MultipartFile mf = mr.getFile("proImg");
		String filename = aws.uploadImg(mf);
		
		System.out.println("대표 이미지 url : " + filename);
		
		String[] parts = filename.split("/");
		String extractedFilename = parts[parts.length - 1];
		System.out.println("추출된 파일 이름: " + extractedFilename);
		
		File file = new File(root, extractedFilename);

		dto.setProImg(filename);
//		dto.setProImageChange(filename);

		try {
			mf.transferTo(file);
		} catch (IOException e) {
			req.setAttribute("msg", "대표이미지 등록에 실패했습니다.");
			req.setAttribute("url", "/merchant/store/product-input");
			return "message";
		}
		
		proImgPro = mr.getFiles("proImgPro");
		System.out.println("proImgPro" + proImgPro);
		List<MultipartFile> validFiles = new ArrayList<>();
		
		for(MultipartFile file2 : proImgPro) {
			String fileName = file2.getOriginalFilename();
			long fileSize = file2.getSize();
			
    	    // 파일 이름이 비어 있지 않고 파일 크기가 0보다 큰 경우에만 유효한 파일로 간주
    	    if (!fileName.isEmpty() && fileSize > 0) {
    	        validFiles.add(file2);
    	    }
		}
		
		List<String> fileNameList = aws.uploadImage(validFiles);
		System.out.println("상세이미지 사이즈" + fileNameList.size());
		String imgString = String.join(",", fileNameList);
		dto.setProImgPro(imgString);

		// 상세 이미지
//		List<Map<String, String>> fileList = new ArrayList<>();
//		String fileproOri = "";
//		for (int i = 0; i < proImgPro.size(); i++) {
//			String originFile = proImgPro.get(i).getOriginalFilename();
//			String ext = originFile.substring(originFile.lastIndexOf("."));
//			String changeFile = UUID.randomUUID().toString() + ext;
//			Map<String, String> map = new HashMap<>();
//			map.put("originFile", originFile);
//			map.put("changeFile", changeFile);
//			fileproOri += originFile;
//			fileList.add(map);
//		}
//		String filepro = "";
//
//		try {
//			for (int i = 0; i < proImgPro.size(); i++) {
//				File uploadFile = new File(root1 + "\\" + fileList.get(i).get("changeFile"));
//				proImgPro.get(i).transferTo(uploadFile);
//				System.out.println(uploadFile);
//				filepro += fileList.get(i).get(("changeFile")) + ",";
//			}
//
//			System.out.println("다중 파일 업로드 성공");
//
//		} catch (IllegalStateException | IOException e) {
//			System.out.println("다중 파일 업로드 실패");
//			for (int i = 0; i < proImgPro.size(); i++) {
//				new File(root1 + "\\" + fileList.get(i).get("changeFile")).delete();
//			}
//			e.printStackTrace();
//		}
//
//		dto.setProImageProChange(filepro);
//		dto.setProImgPro(fileproOri);
//
		dto.setMerNum(merNum);
//		System.out.println("merNum : " + merNum);
//		System.out.println(dto.getProName());

		// 카테고리명 가져오기
		int categoryNum = Integer.parseInt(req.getParameter("categoryNum"));
		String categoryName = Category.getNameByNum(categoryNum);
		dto.setCategoryName(categoryName);

		// 상품 등록
		String res = proService.insertProduct(dto);

		if (res != null) {
			req.setAttribute("msg", "상품 등록 요청 성공했습니다.");
			// 상품 상세보기로 경로 수정하기
//			req.setAttribute("url", "/merchant/store/product/" + Integer.parseInt(req.getParameter("proNum")));
			req.setAttribute("url", "/merchant/" + req.getParameter("merNum") + "/store/product/stock");
		} else {
			req.setAttribute("msg", "상품 등록 요청 실패했습니다. 다시 시도하세요.");
			req.setAttribute("url", "/merchant/store/product-input");
		}
		return "message";
	}

	// 상품 상세보기
	@GetMapping("/{merNum}/store/product/{proNum}")
	public String productContent(HttpServletRequest req, @RequestParam Map<String, Object> map,
			@PathVariable(value = "merNum") Integer merNum, @PathVariable(value = "proNum") Integer proNum)
			throws IOException {
		String root = PATH + "\\" + "img";
		String root1 = PATH + "\\" + "imgpro";

		Optional<ProductDTO> optionalDto = Optional.of(proService.getProduct(proNum));

//		if (optionalDto.isPresent()) {
//			ProductDTO dto = optionalDto.get();
//			req.setAttribute("getProduct", dto);
//			if (dto.getProImageChange() != null) {
//				File imageFile = new File(root, dto.getProImageChange());
//				if (imageFile.exists()) {
//					String encodedImage = encodeImageToBase64(imageFile);
//					req.setAttribute("encodedImage", encodedImage);
//				}
//			}
//
//			List<String> encodedImagesPro = new ArrayList<>();
//			String[] imageProFiles = dto.getProImageProChange().split(",");
//			for (String imageFileName : imageProFiles) {
//				File imageProFile = new File(root1, imageFileName);
//				if (imageProFile.exists()) {
//					String encodedImagePro = encodeImageToBase64(imageProFile);
//					encodedImagesPro.add(encodedImagePro);
//				}
//			}
//			req.setAttribute("encodedImagesPro", encodedImagesPro);
//		}
//		RequestProductDTO redto = proService.getreProduct(map.get("proNum"));
//
//		if (redto != null) {
//			req.setAttribute("getreProduct", redto);
//
//			File imageFile2 = new File(root, redto.getProImageChange());
//			if (imageFile2.exists()) {
//				String encodedImage2 = encodeImageToBase64(imageFile2);
//				req.setAttribute("encodedImage2", encodedImage2);
//			}
//			List<String> encodedImagesPro2 = new ArrayList<>();
//			String[] imageProFiles2 = redto.getProImageProChange().split(",");
//			for (String imageFileName2 : imageProFiles2) {
//				File imageProFile2 = new File(root1, imageFileName2);
//				if (imageProFile2.exists()) {
//					String encodedImagePro2 = encodeImageToBase64(imageProFile2);
//					encodedImagesPro2.add(encodedImagePro2);
//				}
//			}
//			req.setAttribute("encodedImagesPro2", encodedImagesPro2);
//		}
		return "merchant/store/productManagement/productManagement_content";
	}

	// 상품 조회
	@GetMapping("/{merNum}/store/products")
	public String productList(HttpServletRequest req, @RequestParam Map<String, Object> params,
			@PathVariable(value = "merNum") Integer merNum) throws IOException {
		params.put("merNum", merNum);

		String root = PATH + "\\" + "img";
		req.setAttribute("proImg", root);

		// 재고 관리 리스트
		List<ProductDTO> list = proService.listProduct(params);
//		for (ProductDTO dto : list) {
//			File imageFile = new File(root, dto.getProImageChange());
//			if (imageFile.exists()) {
//				String encodedImage = encodeImageToBase64(imageFile);
//				dto.setEncodedImage(encodedImage);
//			}
//		}

		req.setAttribute("listProduct", list);
		req.setAttribute("listCount", proService.listCount(params));
		return "merchant/store/productManagement/productManagement_list";
	}

	// 요청 리스트
	@GetMapping("/{merNum}/store/product/request")
	public String productRequest(HttpServletRequest req, @RequestParam Map<String, Object> params,
			@PathVariable(value = "merNum") Integer merNum) throws IOException {
		params.put("merNum", merNum);
		String root = PATH + "\\" + "img";
		req.setAttribute("proImg", root);
		// 요청 리스트
		List<ProductDTO> list = proService.requestList(params);
//		for (ProductDTO dto : list) {
//			File imageFile = new File(root, dto.getProImageChange());
//			if (imageFile.exists()) {
//				String encodedImage = encodeImageToBase64(imageFile);
//				dto.setEncodedImage(encodedImage);
//			}
//		}
		req.setAttribute("requestListProduct", list);
		req.setAttribute("requestListCount", proService.requestListCount(params));
		return "merchant/store/productManagement/productManagement_request_list";
	}

	// 재고 관리
	@GetMapping("/{merNum}/store/product/stock")
	public String productStock(HttpServletRequest req, @RequestParam Map<String, Object> params,
			@PathVariable(value = "merNum") Integer merNum) throws IOException {
		params.put("merNum", merNum);

		String root = PATH + "\\" + "img";
		req.setAttribute("proImg", root);

		String[] specArray = req.getParameterValues("spec");
		List<String> spec = (specArray != null) ? Arrays.asList(specArray) : new ArrayList<String>();
		params.put("spec", spec);

		// 재고 관리 리스트
		List<ProductDTO> list = proService.stockList(params);
//		for (ProductDTO dto : list) {
//			File imageFile = new File(root, dto.getProImageChange());
//			if (imageFile.exists()) {
//				String encodedImage = encodeImageToBase64(imageFile);
//				dto.setEncodedImage(encodedImage);
//			}
//		}

		req.setAttribute("stockListProduct", list);
		req.setAttribute("stockListCount", proService.stockListCount(params));
		return "merchant/store/productManagement/productManagement_stock";
	}

	@PostMapping("/{merNum}/store/product/stock/{proNum}")
	public String updateProductStock(HttpServletRequest req, @PathVariable("merNum") Integer merNum,
			@PathVariable("proNum") Integer proNum, @RequestParam Map<String, Object> params) {
		req.setAttribute("mer_num", params.get("mer_num"));
		boolean res = proService.updateProductStock(params);
		if (res) {
			req.setAttribute("msg", "재고 수정에 성공했습니다.");
		} else {
			req.setAttribute("msg", "재고 수정에 실패했습니다.");
		}
		req.setAttribute("url", "/merchant/" + merNum + "/store/product/stock");
		return "message";
	}
}
