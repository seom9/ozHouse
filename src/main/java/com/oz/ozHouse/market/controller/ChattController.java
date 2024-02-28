package com.oz.ozHouse.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oz.ozHouse.client.security.MemberSecurityDTO;
import com.oz.ozHouse.domain.Chatt;
import com.oz.ozHouse.domain.ChattRoom;
import com.oz.ozHouse.dto.OzMarketProDTO;
import com.oz.ozHouse.market.service.ChattRoomService;
import com.oz.ozHouse.market.service.ChattService;
import com.oz.ozHouse.market.service.MarketProService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ozMarket")
public class ChattController {

	private final ChattRoomService chattRoomService;

	private final ChattService chattService;

	private final MarketProService marketProService;

	private static final String PATH = "C:\\ozMarket\\";

	// base64 인코딩
	private String encodeImageToBase64(File file) throws IOException {

		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// 파일의 크기만큼 바이트 배열을 생성
			byte[] imageData = new byte[(int) file.length()];

			// 파일 내용을 읽어서 바이트 배열에 저장
			imageInFile.read(imageData);

			// 바이트 배열을 Base64 문자열로 인코딩
			return Base64.getEncoder().encodeToString(imageData);
		}
	}

	// 채팅 리스트
	@GetMapping("/chatts")
	public String chatList(Model model, @AuthenticationPrincipal MemberSecurityDTO member, HttpServletRequest req) {
		if (member == null) {
			req.setAttribute("msg", "로그인 후 이용가능합니다.");
			req.setAttribute("url", "/main");
			return "message";
		}
		List<ChattRoom> roomList = chattRoomService.findBymyId(member.getMemberNickname());
		String nickname = member.getMemberNickname();

		roomList.forEach(room -> {
	        Optional<Chatt> lastMessage = Optional.ofNullable(chattService.findLastMessageByRoomNum(room.getRoomNum()));
	        if (lastMessage.isPresent()) {
	            room.setLastMessage(lastMessage.get().getMsg());
	        } else {
	            room.setLastMessage("주고 받은 메시지가 없습니다.");
	        }
	        
//	        if (room.getMyId() == nickname) {
//	            room.setPartner(room.getOtherId());
//	        } else {
//	            room.setPartner(room.getMyId());
//	        }
	    });
		
		for (ChattRoom r : roomList) {
			if (r.getMyId().equals(nickname)) {
				r.setPartner(r.getOtherId());
			} else {
				r.setPartner(r.getMyId());
			}
		}

		model.addAttribute("roomList", roomList);
		model.addAttribute("nickname", nickname);

		return "client/ozMarket/chatRoom";
	}

	// 채팅방 생성
	@PostMapping("/chatt")
	public String createChatRoom(@AuthenticationPrincipal MemberSecurityDTO member,
			@RequestParam("proNum") Integer proNum, @RequestParam("sellerNickname") String sellerNickname, // Corrected
																											// parameter
																											// name to
																											// match the
																											// form
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
	public String chatRoom(HttpServletRequest req, @AuthenticationPrincipal MemberSecurityDTO member, Model model,
			@PathVariable("roomNum") String roomNum) throws IOException {
		ChattRoom room = chattRoomService.findRoomByNum(Integer.parseInt(roomNum));
		List<ChattRoom> roomList = chattRoomService.findBymyId(member.getMemberNickname());

		String nickname = member.getMemberNickname();

		for (ChattRoom r : roomList) {
			if (r.getMyId().equals(nickname)) {
				r.setPartner(r.getOtherId());
			} else {
				r.setPartner(r.getMyId());
			}
		}

		model.addAttribute("roomList", roomList);
		model.addAttribute("memberNickname", member.getMemberNickname());
		model.addAttribute("roomNum", roomNum);
		model.addAttribute("room", room);
		model.addAttribute("nickname", nickname);

		Integer proNum = room.getProNum();

		String root = PATH + "\\" + "img";
		Optional<OzMarketProDTO> optionalDto = Optional.of(marketProService.getProduct(proNum));

		if (optionalDto.isPresent()) {
			OzMarketProDTO dto = optionalDto.get();
			req.setAttribute("getProduct", dto);

			List<String> encodedImagesPro = new ArrayList<>();
			String[] imageProFiles = dto.getProImageChange().split(",");
			for (String imageFileName : imageProFiles) {
				File imageProFile = new File(root, imageFileName);
				if (imageProFile.exists()) {
					String encodedImagePro = encodeImageToBase64(imageProFile);
					encodedImagesPro.add(encodedImagePro);
				}
			}
			req.setAttribute("encodedImages", encodedImagesPro);
		}

		String partnerNickname;
		if (room.getMyId().equals(nickname)) {
			partnerNickname = room.getOtherId();
		} else {
			partnerNickname = room.getMyId();
		}
		
		roomList.forEach(room1 -> {
	        Optional<Chatt> lastMessage = Optional.ofNullable(chattService.findLastMessageByRoomNum(room1.getRoomNum()));
	        if (lastMessage.isPresent()) {
	            room1.setLastMessage(lastMessage.get().getMsg());
	        } else {
	            room1.setLastMessage("주고 받은 메시지가 없습니다.");
	        }
	    });
		model.addAttribute("partnerNickname", partnerNickname);

		model.addAttribute("roomList", roomList);
		model.addAttribute("nickname", nickname);

		return "client/ozMarket/chatt";
	}

	// 채팅방 메시지 로드 엔드포인트
	@CrossOrigin
	@GetMapping("/chattRoom/messages/{roomNum}")
	public ResponseEntity<List<Chatt>> getMessagesByRoomNum(@PathVariable("roomNum") Integer roomNum) {
		List<Chatt> messages = chattService.findMessagesByRoomNum(roomNum);
		return ResponseEntity.ok(messages);
	}

	@PostMapping("/reserveProduct/{proNum}")
	public String reserveProduct(HttpServletRequest req, @PathVariable("proNum") Integer proNum,
			@AuthenticationPrincipal MemberSecurityDTO member) {
		boolean res = marketProService.reserveProduct(proNum, member.getMemberNickname());
		if (res) {
			req.setAttribute("msg", "성공했습니다.");
		} else {
			req.setAttribute("msg", "실패했습니다. 다시 시도하세요.");
		}
		req.setAttribute("url", "/ozMarket/myInfo");
		return "message";
	}

	@PostMapping("/confirmPurchase/{proNum}")
	public String confirmPurchase(HttpServletRequest req, @PathVariable("proNum") Integer proNum,
			@AuthenticationPrincipal MemberSecurityDTO member) {
		boolean res = marketProService.confirmPurchase(proNum, member.getMemberNickname());
		if (res) {
			req.setAttribute("msg", "성공했습니다.");
		} else {
			req.setAttribute("msg", "실패했습니다. 다시 시도하세요.");
		}
		req.setAttribute("url", "/ozMarket/myInfo");
		return "message";
	}

	@PostMapping("/cancelReservation/{proNum}")
	public String cancelReservation(HttpServletRequest req, @PathVariable("proNum") Integer proNum) {
		boolean res = marketProService.cancelReservation(proNum);
		if (res) {
			req.setAttribute("msg", "성공했습니다.");
		} else {
			req.setAttribute("msg", "실패했습니다. 다시 시도하세요.");
		}
		req.setAttribute("url", "/ozMarket/myInfo");
		return "message";
	}

	@PostMapping("/deleteChatRoom/{roomNum}")
	public String deleteChatRoom(@PathVariable("roomNum") int roomNum, Model model) {
	    
		chattService.deleteMessagesByRoomNum(roomNum);

		// 채팅방 삭제 기능을 호출하고 결과를 받아옵니다.
	    chattRoomService.deleteChatRoom(roomNum);
	    
	    // 채팅방 목록 페이지로 리다이렉트합니다.
	    return "redirect:/ozMarket/chatts";
	}


}