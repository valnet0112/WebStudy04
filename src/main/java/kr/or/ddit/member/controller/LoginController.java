package kr.or.ddit.member.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.member.exception.AuthenticateException;
import kr.or.ddit.member.service.AuthenticateService;
import kr.or.ddit.validate.LoginGroup;
import kr.or.ddit.vo.MemberVO;
@Controller
@RequestMapping("/login/loginProcess.do")
public class LoginController{
	@Inject
	private AuthenticateService service;
	
	@Inject  
	private WebApplicationContext context;
	private String contextPath;
	
	@PostConstruct //모든 주입이 끝난후에 생성된다. 그후에 init이 생성됨
	public void init() {
		contextPath = context.getServletContext().getContextPath(); //톰캣하고 대화가가능
	}
	
	@PostMapping
	public String loginProcess(   //RequestParam으로 받으면 안되는이유?? 404
		@Validated(LoginGroup.class) MemberVO inputData	
		, BindingResult errors
		, HttpSession session
		, Optional<String> rememberMe
		, HttpServletResponse resp
		, RedirectAttributes redirectAttributes
	){
		boolean valid = !errors.hasErrors();
		String logicalViewName = null;
		String message = null;
		if(valid) {
			try{
				MemberVO authMember = service.authenticate(inputData);
				if(session.isNew()) {
					message = "브라우저의 설정 오류, 쿠키 정보를 확인하셈.";
					logicalViewName = "/login/loginForm.jsp";
				}else {
					logicalViewName = "/";
					session.setAttribute("authMember", authMember);
					int maxAge = rememberMe
										.map(rv->60*60*24*3)
										.orElse(0);
					Cookie rememberMeCookie = new Cookie("rememberMe", inputData.getMemId());
					rememberMeCookie.setMaxAge(maxAge);
					rememberMeCookie.setPath(contextPath);
					resp.addCookie(rememberMeCookie);
				}
			}catch(AuthenticateException e){
				message = "아이디나 비밀번호 오류";
				logicalViewName = "/login/loginForm.jsp";
			}	
		}else {
//			resp.sendError(400);
			message = "아이디나 비밀번호 누락";
			logicalViewName = "/login/loginForm.jsp";
		}
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:"+logicalViewName;
	}
}












