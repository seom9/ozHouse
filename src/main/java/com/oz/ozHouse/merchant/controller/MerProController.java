package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;
import com.oz.ozHouse.merchant.service.MerProService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant/store")
public class MerProController {

	private final MerProService proService;

	private static final String PATH = "C:\\proImgs\\";

	//base64 인코딩
	private String encodeImageToBase64(File file) throws IOException {
		
	    // Java 7 이상에서 제공하는 try-with-resources 구문을 사용하여 자동으로 리소스를 해제합니다.
	    try (FileInputStream imageInFile = new FileInputStream(file)) {
	    	
	        // 파일의 크기만큼 바이트 배열을 생성합니다.
	        byte[] imageData = new byte[(int) file.length()];
	        
	        // 파일 내용을 읽어서 바이트 배열에 저장합니다.
	        imageInFile.read(imageData);
	        
	        // 바이트 배열을 Base64 문자열로 인코딩합니다.
	        return Base64.getEncoder().encodeToString(imageData);
	    }
	}

	// 상품 등록
	@GetMapping("/product-input")
	public String proInput(HttpServletRequest req) {
		// 입점 신청시 등록한 카테고리 연동하기
		req.setAttribute("categories", Category.values());
		System.out.println("등록 폼");
		return "merchant/store/productManagement/productManagement_input";
	}

	@PostMapping("/product-input")
	public String proInput(@RequestParam("proImg") 
	List<MultipartFile> proImg, @RequestParam("proImgPro") 
	List<MultipartFile> proImgPro, 
	MultipartHttpServletRequest multipartRequest, 
	HttpServletRequest req, 
	@RequestParam Map<String, String> params
//	@ModelAttribute ProductDTO dto
	) throws Exception {
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
		}catch(IOException e) {
			req.setAttribute("msg", "대표이미지 등록에 실패했습니다.");
			req.setAttribute("url", "/merchant/store/product-input");
			return "message";
		}
		
		//상세 이미지
		System.out.println("proImgPro : " + proImgPro);
		
		List<Map<String, String>> fileList = new ArrayList<>();
		String fileproOri = "";
		for(int i = 0; i < proImgPro.size(); i++) {
			String originFile = proImgPro.get(i).getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString() + ext;
			Map<String, String> map = new HashMap<>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);
			fileproOri += originFile;
			System.out.println("originFIle : " + originFile);
			System.out.println("changeFile : " + changeFile);
			fileList.add(map);
		}
		String filepro = "";
		
		try {
			for(int i = 0; i < proImgPro.size(); i++) {
				File uploadFile = new File(root1 + "\\" + fileList.get(i).get("changeFile"));
				System.out.println("fileList : " + fileList.get(i).get("changeFile"));
				System.out.println("originFIle : " + fileList.get(i).get("originFIle"));

				proImgPro.get(i).transferTo(uploadFile);
				System.out.println(uploadFile);
				filepro += fileList.get(i).get(("changeFile")) + ",";
				
				System.out.println(filepro);
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
		
//		HttpSession session = req.getSession();
//		session.setAttribute("proImg", root);
//		session.setAttribute("proImgPro", root1);
//		System.out.println("root : " + session.getAttribute("proImg"));
//		System.out.println("root1 : " + session.getAttribute("proImgPro"));
//		dto.setmerNum(merNum);
		System.out.println(dto.getProName());
		// 카테고리 번호를 기반으로 카테고리 이름을 조회
		int categoryNum = Integer.parseInt(req.getParameter("categoryNum")); // 또는 다른 방식으로 categoryNum을 얻습니다.
		String categoryName = Category.getNameByNum(categoryNum);
		dto.setCategoryName(categoryName);
		System.out.println("카테고리 Num : " + dto.getCategoryNum());
		System.out.println("카테고리명 : " + dto.getCategoryName());
		String res = proService.insertProduct(dto);
		System.out.println("insertProduct실행?");
		if (res != null) {
			req.setAttribute("msg", "상품 등록 요청 성공했습니다.");
			req.setAttribute("url", "/merchant/store/products");
		}else {
			req.setAttribute("msg", "상품 등록 요청 실패했습니다. 다시 시도하세요.");
			req.setAttribute("url", "/merchant/store/product-input");
		}
		return "message";
	}
	
	//상품 상세보기
	@GetMapping("/product")
	public String productContent() {
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
		System.out.println("재고관리");
	    String root = PATH + "\\" + "img";
	    req.setAttribute("proImg", root);
//	    
//	    String[] specArray = req.getParameterValues("spec");
//	    List<String> spec = (specArray != null) ? Arrays.asList(specArray) : new ArrayList<String>();
//	    params.put("spec", spec);

	    //재고 관리 리스트
	    List<ProductDTO> list = proService.stockList();
	    for (ProductDTO dto : list) {
	        File imageFile = new File(root, dto.getProImageChange());
	        if (imageFile.exists()) {
	            String encodedImage = encodeImageToBase64(imageFile);
	            dto.setEncodedImage(encodedImage); 
	        }
	    }
	    req.setAttribute("stockListProduct", proService.stockList());
	    
//	    int stockListCount = proService.merchant_stockListCount(params);
	    req.setAttribute("stockListCount", proService.stockListCount());

		return "merchant/store/productManagement/productManagement_stock";
	}
	
	@Transactional
	@PutMapping("/product/stock/{proNum}")
	public ResponseEntity<?> updateProductStock(@PathVariable Integer proNum, @RequestParam Integer newQuantity) {
        try {
            proService.updateProductStock(proNum, newQuantity);
            return ResponseEntity.ok().body("재고가 성공적으로 업데이트되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("재고 업데이트 중 오류가 발생했습니다.");
        }
    }
}
