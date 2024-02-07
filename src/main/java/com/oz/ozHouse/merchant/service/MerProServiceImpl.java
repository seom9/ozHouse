package com.oz.ozHouse.merchant.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.oz.ozHouse.domain.Product;
import com.oz.ozHouse.domain.common.Image;
import com.oz.ozHouse.dto.ProductDTO;
import com.oz.ozHouse.merchant.repository.MerProductRepository;
import lombok.RequiredArgsConstructor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MerProServiceImpl implements MerProService {

//	private final MerProductRepository proRepository;
//
//	private static final String UPLOAD_DIR = "C:\\proImgs\\";
//
//	public void saveProduct(ProductDTO productDTO, MultipartFile proImg, List<MultipartFile> proImgPro) throws IOException {
//        Product product = convertDtoToEntity(productDTO);
//
//        Image image = new Image();
//        if (!proImg.isEmpty()) {
//            String fileName = saveFile(proImg);
//            image.setProImg(fileName);
//        }
//
//        StringBuilder additionalImages = new StringBuilder();
//        for (MultipartFile file : proImgPro) {
//            if (!file.isEmpty()) {
//                String fileName = saveFile(file);
//                additionalImages.append(fileName).append(";");
//            }
//        }
//
//        if (additionalImages.length() > 0) {
//            image.setProImgPro(additionalImages.toString().trim());
//        }
//        
//        product.setProImage(image);
//
//        proRepository.save(product);
//    }
//
//    private Product convertDtoToEntity(ProductDTO dto) {
//        Product product = new Product();
//        return product;
//    }
//
//    private String saveFile(MultipartFile file) throws IOException {
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        Path path = Paths.get(UPLOAD_DIR + fileName);
//        Files.copy(file.getInputStream(), path);
//        return fileName;
//    }
}
