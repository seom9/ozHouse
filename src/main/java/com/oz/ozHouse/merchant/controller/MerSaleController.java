package com.oz.ozHouse.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oz.ozHouse.dto.merchant.SaleConditionDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/merchant/{merNum}/store")
@RequiredArgsConstructor
public class MerSaleController {
	//private final MerSaleService saleService;

	@GetMapping("/sales")
	public String salesList(HttpServletRequest req, @ModelAttribute SaleConditionDTO dto) {
//		List<ListDTO> list = null;
//		if(map.get("mode").equals("day")) {
//			if(!map.containsKey("startDate") && !map.containsKey("endDate")) {
//				String today = cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE);
//				today = today.substring(2);
//				map.put("startDate", today);
//				map.put("endDate", today);
//			}
//			list = saleService.selectListDay(map);
//		}else if(map.get("mode").equals("month")) {
//			Map options = selectMonth(map.get("sYear"), map.get("sMonth"),map.get("eYear"), map.get("eMonth"));  //jsp �뜝�룞�삕�뜝�룞�삕
//			Map date = settingMonth(map.get("sYear"), map.get("sMonth"),map.get("eYear"), map.get("eMonth"));		//query �뜝�룞�삕�뜝�룞�삕
//			map.put("startDate", (String)date.get("startDate"));
//			map.put("endDate", (String)date.get("endDate"));
//			list = saleService.selectListMonth(map);
//			req.setAttribute("options", options);
//		}else {
//			Map options = selectYear(map.get("sYear"), map.get("eYear"));
//			Map date = settingYear(map.get("sYear"),map.get("eYear"));
//			map.put("startYear", (String)date.get("startYear"));
//			map.put("endYear", (String)date.get("endYear"));
//			list = saleService.selectListYear(map);
//			req.setAttribute("options", options);
//		}
//		req.setAttribute("map", map);
//		req.setAttribute("salesList", list);
		return "merchant/store/sales/sales_list";
	}
}
