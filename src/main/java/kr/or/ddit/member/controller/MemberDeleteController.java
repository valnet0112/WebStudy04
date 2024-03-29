package kr.or.ddit.member.controller;

import java.security.Principal;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

// POJO(PlainOldJavaObject)
@Controller
@RequestMapping("/member/memberDelete.do")
public class MemberDeleteController{
	@Inject
	private MemberService service;
	@PostMapping
	public String deleteProcess(
			Principal principal
			, String password
			, RedirectAttributes redirectAttributes
		) {
//		HttpSession session = req.getSession();
		String memId = principal.getName();
		MemberVO inputData = new MemberVO(memId, password);
		ServiceResult result = service.removeMember(inputData);
		String logicalViewName = null;
		String message = null;
		switch (result) {
		case INVALIDPASSWORD:
			message = "비밀 번호 오류";
			logicalViewName = "redirect:/mypage";
			redirectAttributes.addFlashAttribute("message", message);
			break;
		case OK:
//			session.invalidate();  //로그아웃을 시키기위해서
			logicalViewName = "forward:/login/logOut.do";  //포스트 요청을 그대로 유지한상태에서 컨트롤러로가야함
			break;
		default:
			message = "서버 오류, 쫌따 다시 탈퇴하셈.";
			logicalViewName = "redirect:/mypage";
			redirectAttributes.addFlashAttribute("message", message);
			break;
		}
		
		return logicalViewName;
	}
}























