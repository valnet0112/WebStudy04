package kr.or.ddit.prod.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodInsert.do")
public class ProdInsertController{
	@Inject
	private ProdService service;
	
	@ModelAttribute("prod")
	public ProdVO prod() {
		return new ProdVO();
	}
	
	// view layer 로 연결하기 위한 컨트롤러
	@GetMapping
	public String insertForm(){
		return "prod/prodForm";
	}
	
	// form 을 통해 전송된 데이터에 대한 처리를 위한 컨트롤러
	@PostMapping
	public String insertProcess(
		@Validated(InsertGroup.class) @ModelAttribute("prod") ProdVO prod	
		, BindingResult errors
		, Model model
	){
		
		String logicalViewName = null;
		if(!errors.hasErrors()) {
	//		3. 등록 로직 호출
				ServiceResult result = service.createProd(prod);
	//		4. 로직의 실행 결과에 따른 뷰 선택
				String message = null;
				switch (result) {
				case OK:
					logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId(); // Post-Redirect-Get
					break;
				default:
					logicalViewName = "prod/prodForm";
					break;
				}
				
				model.addAttribute("message", message);
		}else {
			logicalViewName = "prod/prodForm";
		}
		
		return logicalViewName;
	}
}	
