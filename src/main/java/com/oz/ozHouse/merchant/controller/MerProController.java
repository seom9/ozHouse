package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.service.MerProService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant")
public class MerProController {

	private final MerProService proService;

	private static final String PATH = "C:\\proImgs\\";

	//base64 인코딩
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
		return "merchant/store/productManagement/productManagement_input";
	}

	@PostMapping("/{merNum}/store/product-input")
	public String proInput(@RequestParam("proImg") List<MultipartFile> proImg, @RequestParam("proImgPro") List<MultipartFile> proImgPro, 
	HttpServletRequest req, @RequestParam Map<String, String> params) throws Exception {
		
		ProductDTO dto = new ProductDTO(req);
		
		//대표 이미지 폴더 지정
		String root = PATH + "\\" + "img";
		
		File fileCheck = new File(root);
		if (!fileCheck.exists()) fileCheck.mkdir();
		
		//상세 이미지 폴더 지정
		String root1 = PATH + "\\" + "imgpro";
		
		File fileCheck1 = new File(root1);
		if (!fileCheck1.exists()) fileCheck1.mkdir();
		
		//대표 이미지
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile mf = mr.getFile("proImg");
		String filename = mf.getOriginalFilename();
		String ext1 = filename.substring(filename.lastIndexOf("."));
		String changeFile1 = UUID.randomUUID().toString() + ext1;
		
		File file = new File(root, changeFile1);

		dto.setProImg(filename);
		dto.setProImageChange(changeFile1);
		
		try {
			mf.transferTo(file);
		} catch(IOException e) {
			req.setAttribute("msg", "대표이미지 등록에 실패했습니다.");
			req.setAttribute("url", "/merchant/store/product-input");
			return "message";
		}
		
		//상세 이미지
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
				File uploadFile = new File(root1 + "\\" + fileList.get(i).get("changeFile"));
				proImgPro.get(i).transferTo(uploadFile);
				System.out.println(uploadFile);
				filepro += fileList.get(i).get(("changeFile")) + ",";
			}
			
			System.out.println("다중 파일 업로드 성공");
			
		} catch (IllegalStateException | IOException e) {
			System.out.println("다중 파일 업로드 실패");
			for(int i = 0; i < proImgPro.size(); i++) {
				new File(root1 + "\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}
		
		dto.setProImageProChange(filepro);
		dto.setProImgPro(fileproOri);
		
//		dto.setmerNum(merNum);
		System.out.println(dto.getProName());
		
		//카테고리명 가져오기
		int categoryNum = Integer.parseInt(req.getParameter("categoryNum")); 
		String categoryName = Category.getNameByNum(categoryNum);
		dto.setCategoryName(categoryName);
		
		//상품 등록
		String res = proService.insertProduct(dto);
		
		if (res != null) {
			req.setAttribute("msg", "상품 등록 요청 성공했습니다.");
			//상품 상세보기로 경로 수정하기
			req.setAttribute("url", "/merchant/store/product/" + Integer.parseInt(req.getParameter("proNum")));
		}else {
			req.setAttribute("msg", "상품 등록 요청 실패했습니다. 다시 시도하세요.");
			req.setAttribute("url", "/merchant/store/product-input");
		}
		return "message";
	}
	
	//상품 상세보기
	@GetMapping("/product/{proNum}")
	public String productContent(HttpServletRequest req, @RequestParam Map<String, String> map) throws IOException {
		   String root = PATH + "\\" + "img";
	       String root1 = PATH + "\\" + "imgpro";
	       
	       System.out.println("product_num : " + map.get("product_num"));
//	       ProductDTO dto = productManagementMapper.merchant_getProduct(map.get("product_num"));
//
//	       req.setAttribute("getProduct", dto);
//
//	       // ���몴�씠誘몄� �씤肄붾뵫
//	       File imageFile = new File(root, dto.getProduct_image_change());
//	       if (imageFile.exists()) {
//	           String encodedImage = encodeImageToBase64(imageFile);
//	           req.setAttribute("encodedImage", encodedImage);
//	       }
//	       
//	       // �긽�꽭�씠誘몄� �씤肄붾뵫
//	       List<String> encodedImagesPro = new ArrayList<>();
//	       String[] imageProFiles = dto.getProduct_image_pro_change().split(",");
//	       for (String imageFileName : imageProFiles) {
//	           File imageProFile = new File(root1, imageFileName);
//	           if (imageProFile.exists()) {
//	               String encodedImagePro = encodeImageToBase64(imageProFile);
//	               encodedImagesPro.add(encodedImagePro);
//	           }
//	       }
//	       req.setAttribute("encodedImagesPro", encodedImagesPro);
//	       
//	       RequestProductDTO redto = productManagementMapper.merchant_getreProduct(map.get("product_num"));
//
//	       if (redto != null) {
//		       req.setAttribute("getreProduct", redto);
//
//		       File imageFile2 = new File(root, redto.getProduct_image_change());
//		       if (imageFile2.exists()) {
//		           String encodedImage2 = encodeImageToBase64(imageFile2);
//		           req.setAttribute("encodedImage2", encodedImage2);
//		       	}
//		       List<String> encodedImagesPro2 = new ArrayList<>();
//		       String[] imageProFiles2 = redto.getProduct_image_pro_change().split(",");
//		       for (String imageFileName2 : imageProFiles2) {
//		           File imageProFile2 = new File(root1, imageFileName2);
//		           if (imageProFile2.exists()) {
//		               String encodedImagePro2 = encodeImageToBase64(imageProFile2);
//		               encodedImagesPro2.add(encodedImagePro2);
//		           }
//		       }
//		       req.setAttribute("encodedImagesPro2", encodedImagesPro2);
//	       }
	       return "merchant/store/productManagement/productManagement_content";
	   }

	// 상품 조회
	@GetMapping("/products")
	public String productList() {
		return "merchant/store/productManagement/productManagement_list";
	}

	// 요청 리스트
	@GetMapping("/product/request")
	public String productRequest() {
		return "merchant/store/productManagement/productManagement_request_list";
	}

	// 재고 관리
	@GetMapping("/product/stock")
	public String productStock(HttpServletRequest req, @RequestParam Map<String, Object> params) throws IOException {
	    System.out.println("재고");
		String root = PATH + "\\" + "img";
	    req.setAttribute("proImg", root);
	    
	    String[] specArray = req.getParameterValues("spec");
	    List<String> spec = (specArray != null) ? Arrays.asList(specArray) : new ArrayList<String>();
	    params.put("spec", spec);

	    //재고 관리 리스트
	    List<ProductDTO> list = proService.stockList(params);
	    for (ProductDTO dto : list) {
	        File imageFile = new File(root, dto.getProImageChange());
	        if (imageFile.exists()) {
	            String encodedImage = encodeImageToBase64(imageFile);
	            dto.setEncodedImage(encodedImage); 
	        }
	    }
	    req.setAttribute("stockListProduct", list);
	    req.setAttribute("stockListCount", proService.stockListCount(params));
		return "merchant/store/productManagement/productManagement_stock";
	}
	
	@Transactional
	@PutMapping("/product/stock/{proNum}")
	public String updateProductStock(@PathVariable Integer proNum, @RequestParam Map<String, String> params) {
        return "message";
    }
}
