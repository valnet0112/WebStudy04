package kr.or.ddit.basetech.designpattern.adapter.material;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adaptee {
	public void specificRequest() {
		log.info("아주 특별하게 adaptee에서 요청을 처리했음.");
	}
}
