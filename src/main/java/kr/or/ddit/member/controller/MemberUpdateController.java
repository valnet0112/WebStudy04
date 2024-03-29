package kr.or.ddit.member.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateController{
	@Inject
	private MemberService service;
	
	@GetMapping
	protected String updateForm(Principal principal, Model model){
		MemberVO member = service.retrieveMember(principal.getName());
		model.addAttribute("member", member);
		return "member/memberEdit";
	}
	
	@PostMapping
	public String updateProcess(
			@Validated(UpdateGroup.class) @ModelAttribute("member") MemberVO member
			, BindingResult errors
			, Model model
			, Principal principal
			, RedirectAttributes redirectAttributes
		){
			member.setMemId(principal.getName());
		
		String logicalViewName = null;
		if (!errors.hasErrors()) {
			// 3. 수정 로직 호출
			ServiceResult result = service.modifyMember(member);
			// 4. 로직의 실행 결과에 따른 뷰 선택
			String message = null;
			switch (result) {
			case INVALIDPASSWORD:
				logicalViewName = "member/memberEdit";
				message = "인증 실패";
				break;
			case OK:
				logicalViewName = "redirect:/mypage";
				break;

			default:
				logicalViewName = "member/memberEdit";
				message = "서버 오류";
				break;
			}

			model.addAttribute("message", message);
		} else {
			logicalViewName = "member/memberEdit";
		}
		return logicalViewName;
		
	}
}
