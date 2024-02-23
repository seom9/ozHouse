//package com.oz.ozHouse.chatt.test;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import lombok.RequiredArgsConstructor;
//
////@RestController
//@Controller
//@RequiredArgsConstructor
//public class ChatController {
//    private final ChatService chatService;
//
//
//    @GetMapping("/chat/chatList")
//    public String chatList(Model model){
//        List<ChatRoom> roomList = chatService.findAllRoom();
//        model.addAttribute("roomList",roomList);
//        return "test/chatList";
//    }
//
//
//    @PostMapping("/chat/createRoom")  //방을 만들었으면 해당 방으로 가야지.
//    public String createRoom(Model model, @RequestParam("name") String name
////    		, 
////            @RequestParam("username") String username
//    		) {
//        ChatRoom room = chatService.createRoom(name);
//        model.addAttribute("room",room);
////        String username = user.getUsername();
//        model.addAttribute("username","서아");
//        return "test/chatRoom";  //만든사람이 채팅방 1빠로 들어가게 됩니다
//    }
//    
////
////    @GetMapping("/chat/chatRoom/{roomId}")
////    public String chatRoom(Model model, @PathVariable String roomId){
////        ChatRoom room = chatService.findRoomById(roomId);
////        model.addAttribute("roomId", roomId);
////        model.addAttribute("room",room);   //현재 방에 들어오기위해서 필요한데...... 접속자 수 등등은 실시간으로 보여줘야 돼서 여기서는 못함
////        return "test/chatRoom";
////    }
//    
//    @GetMapping("/chatRoom/{roomId}")
//    public String chatRoom1(Model model, @PathVariable("roomId") String roomId){
//        ChatRoom room = chatService.findRoomById(roomId);
//        model.addAttribute("roomId", roomId);
//        model.addAttribute("room",room);   //현재 방에 들어오기위해서 필요한데...... 접속자 수 등등은 실시간으로 보여줘야 돼서 여기서는 못함
//        return "test/chatRoom";
//    }
//}