package com.oz.ozHouse.merchant.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oz.ozHouse.domain.Category;
import com.oz.ozHouse.dto.InbrandDTO;
import com.oz.ozHouse.dto.merchant.ApplicationDTO;
import com.oz.ozHouse.merchant.exception.NotFoundMerNumException;
import com.oz.ozHouse.merchant.service.MerInbrandService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/merchant/home/brand")
@RequiredArgsConstructor
public class MerInbrandController {
	private final MerInbrandService inbrandService;
	
	static final String FILEPATH = 
			"D:\\project\\ozHouse\\src\\main\\resources\\static\\merchant\\inbrandInfo\\";
	
	private HttpServletRequest goToMessage(HttpServletRequest req, String url, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return req;
	}   
	
	@GetMapping("/applications/{merNum}")
	public String applications(HttpServletRequest req,
			@PathVariable(name = "merNum") int merNum) {
		InbrandDTO dto = inbrandService.selectMer(merNum); //merNum으로 신청내역 조회
		if(dto != null) {	 //조회내역이 있다면
			if(!(dto.getInCancelDate()==null)) {	//조회내역이 있고 취소일자가 있다면
				Calendar calNow = Calendar.getInstance();		
				Calendar calEnd= Calendar.getInstance();	     
				SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
				Date date;
				try {
					date = df.parse(dto.getInCancelDate());
					calEnd.setTime(date);
					calEnd.add(Calendar.MONTH, 3);
					if(calNow.before(calEnd)) {	    	//조회내역이 있고 취소일자가 3개월이 지나지 않았다면
						req = goToMessage(req, 
								"/merchant/home", 
								"입점신청 취소, 또는 거절일로부터 3개월이 지나지 않아 신청이 불가합니다.");
						return "message";
					}else {			                   //조회내역이 있고 취소일자가 3개월이 지났다면					
						req.setAttribute("mer_num", merNum);
						return "merchant/brand/brand_application";
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else {	       //조회내역이 있고 취소일자가 없다면
				req = goToMessage(req,
						"/merchant/home/brand/applicationList/" + merNum, 
						"현재 입점신청 승인중이거나 승인된 상점입니다.");
				return "message";
			}
		}
		req.setAttribute("mer_num", merNum);
		return "merchant/brand/brand_application";
	}
	
	@PostMapping(value="/checkbusiness/{merNum}")
	public String brandApplicationOk(HttpServletRequest req, 
			@RequestParam Map<String, String> map, 
			@PathVariable(name="merNum")int merNum) {
		boolean result = false;
		try {
			result = inbrandService.searchComNum(merNum, map);
		}catch(NotFoundMerNumException e) {
			req = goToMessage(req, 
					"/merchant/home", 
					"존재하지 않는 판매자입니다.");
			return "message";
		}
		if(!result) {
			req = goToMessage(req, 
					"/merchant/home/brand/" + merNum + "/applications", 
					"회원가입시의 사업자등록번호와 일치하지 않습니다.");
			return "message";
		}
		req.setAttribute("category", Category.values());
		req.setAttribute("inbrand_comnum1", map.get("inComnum1"));
		req.setAttribute("inbrand_comnum2", map.get("inComnum2"));
		req.setAttribute("inbrand_comnum3", map.get("inComnum3"));
		req.setAttribute("mer_num", merNum);
		return "merchant/brand/brand_inform";
	}

	@PostMapping(value="/submit")
	public String brandInformOk(HttpServletRequest req ,
			@RequestParam(value="inCategory", required=true) String cate) 
			throws IllegalStateException, IOException {
		String str[] = cate.split(",");
		List<Category> category = new ArrayList<Category>();
		for(String s : str) {
			category.add(Category.valueOf(s));
		}
		InbrandDTO dto = new InbrandDTO(req, category); //save할 객체
		InbrandDTO befor = inbrandService.selectMer(dto.getMerNum());  //이전에 신청한 객체
		if(befor != null) {
			inbrandService.deleteInbrand(befor.getInNum());
		}
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
        MultipartFile mFile = mr.getFile("inSaleFile");
        if (mFile != null && mFile.getSize() > 0) { 
            String saveName = dto.getInComnum1()+ dto.getInComnum2()+ dto.getInComnum3() + "_" + mFile.getOriginalFilename(); 
            mFile.transferTo(new File(FILEPATH + saveName)); 
            dto.setInSaleFile(saveName);
            int res = inbrandService.application(dto);
    	    if(res>0) {
    	    	req = goToMessage(req, 
    	    			"/merchant/home/brand/applicationList/" + dto.getMerNum(), 
    	    			"입점신청이 완료되었습니다.");
    	    }else {
    	    	req = goToMessage(req, 
    	    			"/merchant/home/brand/" + dto.getMerNum() + "/applications", 
    	    			"입점신청이 완료되지 않았습니다.");
    	    }
        }else {
        	req = goToMessage(req, 
        			"/merchant/home/brand/" + dto.getMerNum() + "/applications", 
	    			"판매 관련 파일 업로드시 오류가 발생하였습니다.");
        }
		return "message";
	}
	
	@GetMapping(value="/applicationList/{merNum}")
	public String brandApplicationList(HttpServletRequest req, 
			@PathVariable(name = "merNum") int merNum) {
		ApplicationDTO dto = inbrandService.applicationList(merNum);
		if(dto == null) {
			req = goToMessage(req, 
					"/merchant/home/brand/" + merNum + "/applications",
					"입점신청화면으로 이동합니다.");
			return "message";
		}else {
			req.setAttribute("applicationList", dto);
			return "merchant/brand/brand_applicationList";
		}
	}
	
	@PostMapping(value="/applicationList/{inNum}/cancel")
	public String brandCancel(HttpServletRequest req,
			@PathVariable("inNum") int inNum, @RequestParam("inSaleFile") String inSaleFile) {
		int res = inbrandService.brandCancel(inNum);
		String msg = null;
		String url = null;
		
		if(res>0) {
			File file = new File(FILEPATH + inSaleFile);
			if (file.exists()){
				file.delete();
			}
			msg = "입점신청이 취소되었습니다.";
			url = "/merchant/home";
		}else {
			msg = "입점신청 취소가 완료되지 않았습니다.";
			url = "/merchant/home";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message";
	}
}
