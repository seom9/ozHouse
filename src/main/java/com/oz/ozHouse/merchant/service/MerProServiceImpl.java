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
@RequiredArgsConstructor
public class MerProServiceImpl implements MerProService {
	
	private final MerProductRepository proRepository;

	private static final String PATH = "C:\\proImgs\\";

//	@Override
//	public int saveProduct(ProductDTO productDTO) {
//		Product product = Product.builder()
//	                .proNum(productDTO.getProNum())
//	                .proName(productDTO.getProName())
//	                .categoryNum(productDTO.getCategoryNum())
////	                .merNum(1)
////	                .proImg(product.getImg().getProImg())
////	                .proImgPro(product.getImg().getProImgPro())
//	                .proQuantity(productDTO.getProQuantity())
////	                .proPrice(product.getMerPrice().getProPrice())
//	                .proModifier(productDTO.getProModifier())
////	                .proPoint(product.getMerPrice().getProPoint())
//	                .proInDate(productDTO.getProInDate())
//	                .proSpec("normal")
//	                .proPurchasesCount(0)
//	                .proApprovalStatus("f")
////	                .proAssemblyCost(product.getMerPrice().getProAssemblyCost())
////	                .proDiscountRate(product.getMerPrice().getProDiscountRate())
////	                .proDiscountPrice(product.getMerPrice().getProDiscountPrice())
//	                .categoryName(productDTO.getCategoryName())
////	                .proImageChange(product.getImg().getProImageChange())
////	                .proImageProChange(product.getImg().getProImageProChange())
////	                .encodedImage(product.getImg().getEncodedImage())
//	                .proToday("0")
//	                .build();
//		proRepository.save(product);
//			return productDTO.getProNum();
//	    }


//	@Override
//    public String saveProduct(@RequestParam("proImg") List<MultipartFile> proImg, 
//    		@RequestParam("proImgPro") List<MultipartFile> proImgPro,
//    		MultipartHttpServletRequest multipartRequest, HttpServletRequest req, @ModelAttribute ProductDTO dto, 
//    		BindingResult result, @RequestParam Map<String, String> params) {
//		String root = PATH + "\\" + "img";
//		
//		File fileCheck = new File(root);
//		if (!fileCheck.exists()) fileCheck.mkdir();
//		
//		String root1 = PATH + "\\" + "imgpro";
//		
//		File fileCheck1 = new File(root1);
//		if (!fileCheck1.exists()) fileCheck1.mkdir();
//		
//		if (result.hasErrors()) {
//			ProductDTO.builder().proImg("");
//			ProductDTO.builder().proImgPro("");
//		}
//		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
//		MultipartFile mf = mr.getFile("proImg");
//		String filename = mf.getOriginalFilename();
//		String ext1 = filename.substring(filename.lastIndexOf("."));
//		String changeFile1 = UUID.randomUUID().toString() + ext1;
//		
//		File file = new File(root, changeFile1);
//
//		ProductDTO.builder().proImg(filename);
//		ProductDTO.builder().proImgPro(changeFile1);
//		
//		ProductDTO.builder();
//		
//		System.out.println("dto 저장됨1?" + ProductDTO.builder().proImg(filename));
//		System.out.println("dto 저장됨2?" + ProductDTO.builder().proImgPro(changeFile1));
//		
//		System.out.println("이건? " + dto.getProImgPro());
//		System.out.println("요건?" + ProductDTO.builder());
//		System.out.println("dto" + dto);
//		System.out.println("root : " + root);
//		System.out.println("filename : " + filename);
//		System.out.println("changeFile1 : " + changeFile1);
//		System.out.println("file : " + file);
//		
//		try {
//			mf.transferTo(file);
//		}catch(IOException e) {
//			req.setAttribute("msg", "대표이미지 등록에 실패했습니다.");
//			req.setAttribute("url", "/merchants/products");
//			return "forward:message.jsp";
//		}
//		
//		System.out.println("proImgPro : " + proImgPro);
//		
//		List<Map<String, String>> fileList = new ArrayList<>();
//		String fileproOri = "";
//		for(int i = 0; i < proImgPro.size(); i++) {
//			String originFile = proImgPro.get(i).getOriginalFilename();
//			String ext = originFile.substring(originFile.lastIndexOf("."));
//			String changeFile = UUID.randomUUID().toString() + ext;
//			Map<String, String> map = new HashMap<>();
//			map.put("originFile", originFile);
//			map.put("changeFile", changeFile);
//			fileproOri += originFile;
//			System.out.println("originFIle : " + originFile);
//			System.out.println("changeFile : " + changeFile);
//			fileList.add(map);
//		}
//		System.out.println("root1 : " + root1);
//		String filepro = "";
//		
//		try {
//			for(int i = 0; i < proImgPro.size(); i++) {
//				File uploadFile = new File(root1 + "\\" + fileList.get(i).get("changeFile"));
//				System.out.println("fileList : " + fileList.get(i).get("changeFile"));
//				System.out.println("originFIle : " + fileList.get(i).get("originFIle"));
//
//				proImgPro.get(i).transferTo(uploadFile);
//				System.out.println(uploadFile);
//				filepro += fileList.get(i).get(("changeFile")) + ",";
//				
//				System.out.println(filepro);
//			}
//			
//			System.out.println("다중 파일 업로드 성공!");
//			
//		} catch (IllegalStateException | IOException e) {
//			System.out.println("다중 파일 업로드 실패");
//			for(int i = 0; i < proImgPro.size(); i++) {
//				new File(root1 + "\\" + fileList.get(i).get("changeFile")).delete();
//			}
//			e.printStackTrace();
//		}
//		System.out.println("filepro : " + filepro);
//		System.out.println("fileproOri : " + fileproOri);
//		
//		ProductDTO.builder().proImageProChange(filepro);
//		ProductDTO.builder().proImgPro(fileproOri);
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("proImg", root);
//		session.setAttribute("proImgPro", root1);
//		System.out.println("root : " + session.getAttribute("proImg"));
//		System.out.println("root1 : " + session.getAttribute("proImgPro"));
//		
//		ProductDTO.builder().merNum(1);
////		dto.setMerNum(1);
//		Product product = convertDtoToEntity(dto);
//        proRepository.saveProduct(product);
//        System.out.println(dto.getProName());
//		req.setAttribute("msg", "상품 등록 요청 성공했습니다.");
//		req.setAttribute("url", "/merchants/products");
//        return "forward:message.jsp";
//    }
//	
//	private Product convertDtoToEntity(ProductDTO dto) {
//	    Product product = new Product(dto);
//	    return product;
//	}
	
	@Override
	public void insertProduct(ProductDTO productDTO) {
		proRepository.save(productDTO);
	}
}
