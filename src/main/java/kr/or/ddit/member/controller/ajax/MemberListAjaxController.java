package kr.or.ddit.member.controller.ajax;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.common.paging.SearchCondition;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member/ajax")
public class MemberListAjaxController{
	@Inject
	private MemberService service;
	
	@GetMapping("memberList.do")
	public String listUI() {
		return "member/ajax/memberList";
	}
	
	@GetMapping(value="memberList.do", produces = MediaType.APPLICATION_JSON_VALUE)
	public void listData(  //defaultvalue설정안해도되면 page를 옵셔널로 바꿀수 있다
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
		
		
		}
	@GetMapping(value="memberListResponseBody.do", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody //case8번에서했다
	public List<MemberVO> listData2(  //defaultvalue설정안해도되면 page를 옵셔널로 바꿀수 있다
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
		
		return memberList;
		
		}
}



















