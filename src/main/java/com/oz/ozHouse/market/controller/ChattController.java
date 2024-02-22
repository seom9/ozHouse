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

import com.oz.ozHouse.chatt.test.ChatRoom;
import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.ChattRoomDTO;
import com.oz.ozHouse.market.service.ChattRoomService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ozMarket")
public class ChattController {

    private final ChattRoomService chattRoomService;
    
    @GetMapping("/chatts")
    public String chatList(Model model){
    	List<ChattRoom> roomList = chattRoomService.findAllRooms(); 
        model.addAttribute("roomList", roomList);
        return "client/ozMarket/chatt";
    }
    
    @PostMapping("/chatt")
    public String createChatRoom(@AuthenticationPrincipal MemberSecurityDTO member,
                                 @RequestParam("proNum") Integer proNum,
                                 @RequestParam("memberNickname") String sellerNickname,
                                 HttpServletRequest req, Model model) {
    	
        ChattRoomDTO chattRoomDTO = new ChattRoomDTO(req);
        chattRoomDTO.setMyId(member.getMemberNickname());
        chattRoomDTO.setOtherId(sellerNickname);
        chattRoomDTO.setProNum(proNum);

        ChattRoom room = chattRoomService.createChatRoom(chattRoomDTO);
        
        model.addAttribute("room", room);
        return "redirect:/ozMarket/chattRoom/" + room.getRoomNum(); 
    }
    
    @GetMapping("/chattRoom/{roomNum}")
    public String chatRoom(@AuthenticationPrincipal MemberSecurityDTO member, Model model, @PathVariable("roomNum") Integer roomNum){
        ChattRoom room = chattRoomService.findRoomByNum(roomNum);
        model.addAttribute("memberNickname", member.getMemberNickname());
        model.addAttribute("roomNum", roomNum);
        model.addAttribute("room", room);
        return "client/ozMarket/chatt"; 
    }
}
