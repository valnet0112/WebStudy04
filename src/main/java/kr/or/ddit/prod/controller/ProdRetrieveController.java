package kr.or.ddit.prod.controller;

import java.util.List;
import java.util.Map;

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
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod")
public class ProdRetrieveController{
	
	@Inject
	private ProdService service;
	
	@GetMapping("prodList.do")
	protected String list(
			@RequestParam Map<String, Object>detailCondition
			, @RequestParam(name="page", required = false, defaultValue = "1") int currentPage
			, Model model
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		List<ProdVO> prodList = service.retrieveProdList(paging);
		
		
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		
		model.addAttribute("prodList", prodList);
		model.addAttribute("pagingHTML", pagingHTML);
		model.addAttribute("condition", detailCondition);
		
		return "prod/prodList";
	}
	@GetMapping("prodView.do")
	public String prodOne(@RequestParam("what") String prodId, Model model) {
		ProdVO prod = service.retrieveProd(prodId);
		model.addAttribute("prod", prod);
		return "prod/prodView";
	}
}










