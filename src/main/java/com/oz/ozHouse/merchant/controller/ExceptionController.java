//package com.oz.ozHouse.merchant.controller;
//
//import org.springframework.security.web.firewall.RequestRejectedException;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MissingPathVariableException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.resource.NoResourceFoundException;
//
//import com.oz.ozHouse.merchant.exception.UnauthorizedAccessException;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class ExceptionController {
//
//	// Handle NullPointerException
//	@ExceptionHandler(NullPointerException.class)
//	public String handleNullPointerException(NullPointerException ex, HttpServletRequest req) {
//	    req.setAttribute("msg", ex.getMessage());
//	    req.setAttribute("url", req.getRequestURL());
//	    return "exception";
//	}
//
//
//    // Handle IllegalArgumentException
//    @ExceptionHandler(IllegalArgumentException.class)
//    public String handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest req) {
//    	req.setAttribute("msg", ex.getMessage());
//	    req.setAttribute("url", req.getRequestURL());
//	    return "exception";
//    }
//
//    // Handle MissingPathVariableException
//    @ExceptionHandler(MissingPathVariableException.class)
//    public String handleMissingPathVariableException(MissingPathVariableException ex, HttpServletRequest req) {
//    	req.setAttribute("msg", ex.getMessage());
//	    req.setAttribute("url", req.getRequestURL());
//	    return "exception";
//    }
//
//    // Handle UnauthorizedAccessException
//    @ExceptionHandler(UnauthorizedAccessException.class)
//    public String handleUnauthorizedAccessException(UnauthorizedAccessException ex, HttpServletRequest req) {
//    	req.setAttribute("msg", ex.getMessage());
//	    req.setAttribute("url", req.getRequestURL());
//	    return "exception";
//    }
//    
//    // Handle RequestRejectedException
//    @ExceptionHandler(RequestRejectedException.class)
//    public String handleRequestRejectedException(RequestRejectedException ex, HttpServletRequest req) {
//    	req.setAttribute("msg", ex.getMessage());
//	    req.setAttribute("url", req.getRequestURL());
//	    return "exception";
//    }
//    
// // HttpRequestMethodNotSupportedException 처리
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public String handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest req) {
//    	req.setAttribute("msg", ex.getMessage());
//	    req.setAttribute("url", req.getRequestURL());
//	    return "exception";
//    }
//    
// // HttpRequestMethodNotSupportedException 처리
//    @ExceptionHandler(NoResourceFoundException.class)
//    public String NoResourceFoundException(NoResourceFoundException ex, HttpServletRequest req) {
//    	req.setAttribute("msg", ex.getMessage());
//	    req.setAttribute("url", req.getRequestURL());
//	    return "exception";
//    }
//}
