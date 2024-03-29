package kr.or.ddit.property.controller;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.property.service.PropertyService;
import kr.or.ddit.vo.PropertyVO;

/**
 * RESTfurl URI
 * 명사(자원의 식별자) : /mission/ajax/property
 *  /09/property/property(GET) : 전체 조회  
 *  /09/property/property/a001(GET) : 한건 조회  
 *  /09/property/property/a001(PUT) : 한건 수정
 *  /09/property/property/a001(DELETE) : 한건 삭제
 *  /09/property/property(POST) : 신규 등록
 *
 */

@Controller
@RequestMapping(value="/09/property")
public class PropertyRestController {
	@Inject	
	private PropertyService service;
	
	@GetMapping
	public void getAll(Model model) {
		Set<String> keySet= service.retrieveKeySet();
		model.addAttribute("keySet", keySet);
	}
	
	@GetMapping("{propertyName}")
	public void getOne(@PathVariable String propertyName, Model model) {
		PropertyVO property = service.retrieveProperty(propertyName);
		model.addAttribute("property", property);
	}
	
	@PostMapping
	public String insert(@RequestBody PropertyVO newProp) {
		service.createProperty(newProp);
		return "redirect:/09/property";
	}
	
	@PutMapping("{propertyName}")
	public void update(@RequestBody PropertyVO modifyProp, Model model) {
		boolean success = service.updateProperty(modifyProp);
		model.addAttribute("success", success);
	}
	
	@DeleteMapping("{propertyName}")
	public void delete(@PathVariable String propertyName, Model model) {
		boolean success = service.deleteProperty(propertyName);
		model.addAttribute("success", success);
	}
}



























