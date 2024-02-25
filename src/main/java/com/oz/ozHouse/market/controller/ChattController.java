package com.oz.ozHouse.market.controller;

import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattDTO;
import com.oz.ozHouse.dto.ChattRoomDTO;
import com.oz.ozHouse.market.service.ChattRoomService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ozMarket")
public class ChattController {

    private final ChattRoomService chattRoomService;
    
    // 채팅 리스트
    @GetMapping("/chatts")
    public String chatList(Model model, @AuthenticationPrincipal MemberSecurityDTO member, HttpServletRequest req){
        if (member == null) {
            req.setAttribute("msg", "로그인 후 이용가능합니다.");
            req.setAttribute("url", "/main");
            return "message";
        }
        List<ChattRoom> roomList = chattRoomService.findBymyId(member.getMemberNickname()); 
        model.addAttribute("roomList", roomList);
        return "client/ozMarket/chatRoom";
    }
    
    // 채팅방 생성
    @PostMapping("/chatt")
    public String createChatRoom(@AuthenticationPrincipal MemberSecurityDTO member,
                                 @RequestParam("proNum") Integer proNum,
                                 @RequestParam("sellerNickname") String sellerNickname, // Corrected parameter name to match the form
                                 HttpServletRequest req, Model model) {
        if (member == null) {
            req.setAttribute("msg", "로그인 후 이용가능합니다.");
            req.setAttribute("url", "/main");
            return "message";
        }
        
        ChattRoom room = chattRoomService.findOrCreateRoom(member.getMemberNickname(), sellerNickname, proNum);
        model.addAttribute("room", room);
        return "redirect:/ozMarket/chattRoom/" + room.getRoomNum(); 
    }
    
    // 채팅방 입장
    @GetMapping("/chattRoom/{roomNum}")
    public String chatRoom(@AuthenticationPrincipal MemberSecurityDTO member, Model model, @PathVariable("roomNum") Integer roomNum){
        ChattRoom room = chattRoomService.findRoomByNum(roomNum);
        List<ChattRoom> roomList = chattRoomService.findBymyId(member.getMemberNickname()); 
        model.addAttribute("roomList", roomList);
        model.addAttribute("memberNickname", member.getMemberNickname());
        model.addAttribute("roomNum", roomNum);
        model.addAttribute("room", room);
        return "client/ozMarket/chatt"; 
    }
}
