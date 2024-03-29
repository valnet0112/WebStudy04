package kr.or.ddit.member.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
@Controller
@RequestMapping("/mypage")
public class MypageController{
	@Inject
	private MemberService service;
	
	@GetMapping
	public String mypage(Principal principal, Model model){
		MemberVO member = service.retrieveMember(principal.getName());
		model.addAttribute("member", member);
		
		return "member/mypage";
	}
}













