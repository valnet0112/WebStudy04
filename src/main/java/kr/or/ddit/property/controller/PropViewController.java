package kr.or.ddit.property.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropViewController{
	@RequestMapping("/09/propView.do")
	public String singleView(){
		return  "09/propView";
	}
}
