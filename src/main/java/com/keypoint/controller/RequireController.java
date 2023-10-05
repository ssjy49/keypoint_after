package com.keypoint.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keypoint.dto.RequireDTO;
import com.keypoint.dto.RequireDTO;
import com.keypoint.dto.ReceiveDTO;
import com.keypoint.service.RequireService;

@Controller
@RequestMapping("/require/*")
public class RequireController {
	
	//requireService 객체생성
	@Inject
	private RequireService requireService;
	
//	가상주소 http://localhost:8080/keypoint/require/requireList
	@GetMapping("/requireList")
	public String requireList(Model model) {
		List<RequireDTO> requireList = requireService.getRequireList();
		model.addAttribute("requireList", requireList);
		// WEB-INF/views/require/requireList.jsp
		return "require/requireList";
	}// requireList [소요량목록]
	
	@GetMapping("/requireInsert")
	public String requireInsert() {
		return "require/requireInsert";
	}// requireInsert [소요량등록]	
	
	@PostMapping("/requireInsertPro")
	public String requireInsertPro(RequireDTO requireDTO) {
		System.out.println("RequireController requireInsertPro()");
		//회원가입 처리
		System.out.println(requireDTO);
		
		requireService.insertRequire(requireDTO);
		
		if(requireDTO != null) {
			return "require/msgSuccess"; // 등록완료
		}else {
			return "require/msgFailed"; // 등록실패
		}
	}// requireInsertPro [완제품등록]
	
	@GetMapping("/requireUpdate")
	public String requireUpdate() {
		return "require/requireUpdate";
	}// requireUpdate [소요량수정]
	
	@GetMapping("/requireDelete")
	public String requireDelete(RequireDTO requireDTO) {
		System.out.println("RequireController requireDelete()");
		System.out.println(requireDTO);
		requireService.deleteRequire(requireDTO);
		
		return "require/requireList";
	}// requireDelete [완제품삭제]
	
	
	
	
	
	
	
	
	
	
	
	
	
}// class