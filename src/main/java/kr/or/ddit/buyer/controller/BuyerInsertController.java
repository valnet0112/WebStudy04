package kr.or.ddit.buyer.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.BuyerVO;

@Controller
@RequestMapping("/buyer/buyerInsert.do")
public class BuyerInsertController{
	@Inject
	private BuyerService service;
	public static final String MODELNAME = "targetBuyer";
	
	@ModelAttribute(MODELNAME)
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	
	// view layer 로 연결하기 위한 컨트롤러
	@GetMapping
	public String insertForm(){
		return "buyer/buyerForm";
	}
	
	// form 을 통해 전송된 데이터에 대한 처리를 위한 컨트롤러
	@PostMapping
	public String insertProcess(
		@Validated(InsertGroup.class) @ModelAttribute(MODELNAME) BuyerVO buyer
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
	//		3. 등록 로직 호출
			service.createBuyer(buyer);
	//		4. 로직의 실행 결과에 따른 뷰 선택
			logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId(); // Post-Redirect-Get
		}else {
			redirectAttributes.addFlashAttribute(MODELNAME, buyer);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+MODELNAME, errors);
			logicalViewName = "redirect:/buyer/buyerInsert.do";
		}
		return logicalViewName;
	}
}	






