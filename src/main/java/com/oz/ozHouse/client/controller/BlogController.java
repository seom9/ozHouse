package com.oz.ozHouse.client.controller;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.dto.BlogDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {
	
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
    	
    	MultipartHttpServletRequest mr = (MultipartHttpServletRequest) req;

    	String blogContent = (String) req.getParameter("blogContent");
    	System.out.println("blogContent: " + blogContent);

    	String blogDate = req.getParameter("blogDate");
    	System.out.println("blogDate: " + blogDate);

    	String blogImage = req.getParameter("blogImage");
    	System.out.println("blogImage: " + blogImage);

    	String blogRoomType = req.getParameter("blogRoomType");
    	System.out.println("blogRoomType: " + blogRoomType);

    	String blogSubject = req.getParameter("blogSubject");
    	System.out.println("blogSubject: " + blogSubject);

    	String memberId = req.getParameter("memberId");
    	System.out.println("memberId: " + memberId);

    	
    	return "client/blog/blog_contetns";
    }
    
    @GetMapping("/main")
    public String blogMain() {
    	return "client/blog/blog_main";
    }
}
