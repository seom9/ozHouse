package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.service.MerProService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/merchant")
public class MerProController {

	private final MerProService proService;

	private static final String PATH = "C:\\proImgs\\";


	// 상품 등록
	@GetMapping("/product-input")
	public String proInput(HttpServletRequest req) {
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
		String root = PATH + "\\" + "img";
		
		File fileCheck = new File(root);
		if (!fileCheck.exists()) fileCheck.mkdir();
		
		String root1 = PATH + "\\" + "imgpro";
		
		File fileCheck1 = new File(root1);
		if (!fileCheck1.exists()) fileCheck1.mkdir();
		
//		if (result.hasErrors()) {
//			dto.setproImg("");
//			dto.setproImgPro("");
//		}
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile mf = mr.getFile("proImg");
		String filename = mf.getOriginalFilename();
		String ext1 = filename.substring(filename.lastIndexOf("."));
		String changeFile1 = UUID.randomUUID().toString() + ext1;
		
//		String path = req.getServletContext().getRealPath("/resources/files");
		
//		File file = new File(path, changeFile1);
		File file = new File(root, changeFile1);

		
//		dto.setproImg(filename);
//		dto.setproImg_change(changeFile1);
		
		System.out.println("root : " + root);
		System.out.println("filename : " + filename);
		System.out.println("changeFile1 : " + changeFile1);
		System.out.println("file : " + file);
		
		try {
			mf.transferTo(file);
		}catch(IOException e) {
			req.setAttribute("msg", "대표이미지 등록에 실패했습니다.");
			req.setAttribute("url", "/merchant/product-input");
			return "message";
		}
		
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
		System.out.println("root1 : " + root1);
		String filepro = "";
		
		try {
			for(int i = 0; i < proImgPro.size(); i++) {
//				File uploadFile = new File(path + "\\" + fileList.get(i).get("changeFile"));
				File uploadFile = new File(root1 + "\\" + fileList.get(i).get("changeFile"));
				System.out.println("fileList : " + fileList.get(i).get("changeFile"));
				System.out.println("originFIle : " + fileList.get(i).get("originFIle"));

				proImgPro.get(i).transferTo(uploadFile);
				System.out.println(uploadFile);
				filepro += fileList.get(i).get(("changeFile")) + ",";
				
				System.out.println(filepro);
			}
			
			System.out.println("다중 파일 업로드 성공!");
			
		} catch (IllegalStateException | IOException e) {
			System.out.println("다중 파일 업로드 실패");
			for(int i = 0; i < proImgPro.size(); i++) {
//				new File(path + "\\" + fileList.get(i).get("changeFile")).delete();

				new File(root1 + "\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}
		System.out.println("filepro : " + filepro);
		System.out.println("fileproOri : " + fileproOri);
		
//		dto.setproImageProChange(filepro);
//		dto.setProImgPro(fileproOri);
		
		HttpSession session = req.getSession();
		session.setAttribute("proImg", root);
		session.setAttribute("proImgPro", root1);
		System.out.println("root : " + session.getAttribute("proImg"));
		System.out.println("root1 : " + session.getAttribute("proImgPro"));
//		dto.setmerNum(merNum);
		String res = proService.insertProduct(dto);
		System.out.println("insertProduct실행?");
		System.out.println(dto.getProName());
		if (res != null) {
			req.setAttribute("msg", "상품 등록 요청 성공했습니다.");
			req.setAttribute("url", "/merchant/products");
		}else {
			req.setAttribute("msg", "상품 등록 요청 실패했습니다. 다시 시도하세요.");
			req.setAttribute("url", "/merchant/product-input");
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
	public String productStock() {
		return "merchant/store/productManagement/productManagement_stock";
	}
}
