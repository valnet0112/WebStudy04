package kr.or.ddit.common.controlleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages = "kr.or.ddit")
public class CommonThreadNameControllerAdvice {
	@ModelAttribute("threadName")
	public String threadName() {
		return Thread.currentThread().getName();
	}
}
