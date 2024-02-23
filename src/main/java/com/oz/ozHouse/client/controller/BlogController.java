package com.oz.ozHouse.client.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.client.service.AwsS3Service;
import com.oz.ozHouse.dto.BlogDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {
	
	private static final String PATH = "C:\\File\\";
	private final AwsS3Service aws;
	
    @GetMapping("/write")
    public String blogWrite(@RequestParam(value = "mode", defaultValue = "photo") String mode, Model model) {
        if ("photo".equals(mode)) {
            model.addAttribute("mode", "photo");
            return "client/blog/blog_write";
        } else if ("video".equals(mode)) {
        	model.addAttribute("mode", "video");
            return "client/blog/blog_write";
        } else {
            return "message";
        }
    }
    
    @PostMapping("/write")
    public String blogWritePro(HttpServletRequest req, @ModelAttribute BlogDTO dto, BindingResult result) {
    	
    	if(result.hasErrors()) {
    		dto.setBlogImage("");
    	}
    	
    	// 블로그 이미지 폴더 지정
    	String root = PATH + "\\" + "blogImages";
    	
    	File fileCheck = new File(root);
    	if(!fileCheck.exists()) fileCheck.mkdir();
    	
    	// 블로그 이미지
    	MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;
    	List<MultipartFile> blogImages = mr.getFiles("blogImage");    	
    	
    	List<MultipartFile> validFiles = new ArrayList<>();

    	for (MultipartFile file : blogImages) {
    	    String fileName = file.getOriginalFilename();
    	    long fileSize = file.getSize();
    	    
    	    // 파일 이름이 비어 있지 않고 파일 크기가 0보다 큰 경우에만 유효한 파일로 간주
    	    if (!fileName.isEmpty() && fileSize > 0) {
    	        validFiles.add(file);
    	    }
    	}
    
    	// 유효한 파일들만을 업로드 및 DB 저장을 위해 List값으로 받아옴
    	List<String> fileNameList = aws.uploadImage(validFiles);
    	
	    String[] blogSubjects = mr.getParameterValues("blogSubject");
	    String[] blogContents = mr.getParameterValues("blogContent");
	    String[] blogRoomTypes = mr.getParameterValues("blogRoomType");
	    
	    String imgString = String.join(",", fileNameList);
	    String subjectString = String.join(",", blogSubjects);
	    String contentString = String.join(",", blogContents);
	    String roomTypeString = String.join(",", blogRoomTypes);

	    
	    String urrrrl = aws.GetObjectUrl("ozhouse-bucket", "cf0a4af0-cbc9-4324-bf3b-c6169ed4e381");
	    System.out.println("성공했다 : " + urrrrl);
	    
	    req.setAttribute("urrl", urrrrl);
	    
    	return "client/blog/test";
    }
    
    @GetMapping("/main")
    public String blogMain() {
    	return "client/blog/blog_main";
    }
}
