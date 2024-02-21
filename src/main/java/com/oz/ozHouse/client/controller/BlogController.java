package com.oz.ozHouse.client.controller;

import java.io.File;
import java.sql.Date;
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
    	
    	String[] fileNames = new String[blogImages.size()];
	    for (int i = 0; i < blogImages.size(); i++) {
	        MultipartFile file = blogImages.get(i);
	        fileNames[i] = file.getOriginalFilename();
	    }
	    String[] blogSubjects = mr.getParameterValues("blogSubject");
	    String[] blogContents = mr.getParameterValues("blogContent");
	    String[] blogRoomTypes = mr.getParameterValues("blogRoomType");
	    
	    aws.uploadImage(blogImages);
	    
	    String fileName = String.join(",", fileNames);
	    String subjectString = String.join(",", blogSubjects);
	    String contentString = String.join(",", blogContents);
	    String roomTypeString = String.join(",", blogRoomTypes);
	    
	    System.out.println("File Names: " + fileName);

	    System.out.println("Blog Subjects: " + subjectString);

	    System.out.println("Blog Contents: " + contentString);

	    System.out.println("Blog Room Types: " + roomTypeString);
	    
    	return "client/blog/blog_contetns";
    }
    
    @GetMapping("/main")
    public String blogMain() {
    	return "client/blog/blog_main";
    }
}
