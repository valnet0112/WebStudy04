package kr.or.ddit.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.common.paging.SearchCondition;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member/memberList.do")
public class MemberListController{
	@Inject
	private MemberService service;
	
	@GetMapping
	public String list(  //defaultvalue설정안해도되면 page를 옵셔널로 바꿀수 있다
			@ModelAttribute("paging") PaginationInfo paging
			, @RequestParam(name = "page",required = false, defaultValue = "1") int currentPage
//			, @ModelAttribute("condition") SearchCondition simpleCondition
			, Model model
		) {
//		PaginationInfo paging = new PaginationInfo(3,3);
		paging.setCurrentPage(currentPage);
//		paging.setSimpleCondition(simpleCondition);
		List<MemberVO> memberList = service.retrieveMemberList(paging);
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#submitForm");
		String pagingHTML = renderer.renderPagination(paging);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("pagingHTML", pagingHTML);
		
		return "member/memberList";
		
		}
}



















