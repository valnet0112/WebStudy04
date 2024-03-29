package kr.or.ddit.buyer.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.BuyerVO;

@Controller
@RequestMapping("/buyer/buyerUpdate.do")
public class BuyerUpdateController{
	
	@Inject
	private BuyerService service;
	
	public static final String MODELNAME = "updateBuyer";
	
	@GetMapping
	public String updateForm(@RequestParam String what, Model model){
		BuyerVO buyer = service.retrieveBuyer(what);
		model.addAttribute(MODELNAME, buyer);
		return "buyer/buyerEdit";
	}
	
	@PostMapping
	public String updateProcess(
		@Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) BuyerVO buyer
		, BindingResult errors
		, Model model
		, RedirectAttributes redirectAttributes
	){
		String logicalViewName = null;
		if(!errors.hasErrors()) {
	//		3. 수정 로직 호출
			service.modifyBuyer(buyer);
	//		4. 로직의 실행 결과에 따른 뷰 선택
			logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId();
		}else {
			logicalViewName = "buyer/buyerEdit";
		}
		
		return logicalViewName;
		
	}
}










