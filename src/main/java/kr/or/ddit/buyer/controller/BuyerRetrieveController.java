package kr.or.ddit.buyer.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.vo.BuyerVO;

/**
 * screenSize : 3, blockSize : 2 를 기준으로 페이징 처리.
 * 다음과 같은 검색 상황에 대한 지원.
 * P101 이라는 분류에 해당하는 제조사중 서울 지역의 제조사 중 삼성전자라는 이름이 포함된 제조사 정보를 검색함.
 *
 */
@Controller
@RequestMapping("/buyer")
public class BuyerRetrieveController{
	@Inject
	private BuyerService service;
	
	@GetMapping("buyerList.do")
	public String buyerList(
		@RequestParam Map<String, Object> detailCondition
		, @RequestParam(name="page", required = false, defaultValue = "1") int currentPage
		, Model model
	) {
		
		model.addAttribute("condition", detailCondition);
		
		PaginationInfo paging = new PaginationInfo(3, 2);
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		List<BuyerVO> buyerList = service.retrieveBuyerList(paging);
		
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		
		String pagingHTML = renderer.renderPagination(paging);
		
		model.addAttribute("buyerList", buyerList);
		model.addAttribute("pagingHTML", pagingHTML);
		
		return "buyer/buyerList";
	}
	
	@GetMapping("buyerView.do")
	public String buyerOne(@RequestParam String what, Model model) {
		BuyerVO buyer = service.retrieveBuyer(what);
		model.addAttribute("buyer", buyer);
		
		return "buyer/buyerView";
	}
}
