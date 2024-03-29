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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodUpdate.do")
public class ProdUpdateController{
	@Inject
	private ProdService service;
	
	@ModelAttribute("prod")  //custom태그로 폼을 썻을때 모델속성이 반드시 필요하기 때문에 ??
	public ProdVO prod() {
		return new ProdVO();
	}
	@GetMapping
	public String updateForm(
			@RequestParam String what
			, Model model){
		ProdVO prod = service.retrieveProd(what);
		model.addAttribute("prod", prod);
		return "prod/prodEdit";
	}

	@PostMapping
	public String updateProcess(
			@Validated(UpdateGroup.class) @ModelAttribute("prod") ProdVO prod
			, BindingResult errors
			, Model model
			, RedirectAttributes redirectAttributes
		){
		String logicalViewName = null;
		if (!errors.hasErrors()) {
			// 3. 수정 로직 호출
			ServiceResult result = service.modifyProd(prod);
			// 4. 로직의 실행 결과에 따른 뷰 선택
			String message = null;
			switch (result) {
			case OK:
				logicalViewName = "redirect:/prod/prodView.do?what=" + prod.getProdId();
				redirectAttributes.addFlashAttribute("message","수정 성공");
				break;
			case FAIL:
				logicalViewName = "prod/prodEdit";
				message = "수정 실패";
				break;
			}
			model.addAttribute("message", message);
		} else {
			logicalViewName = "prod/prodEdit";
		}
		return logicalViewName;
	}
}
