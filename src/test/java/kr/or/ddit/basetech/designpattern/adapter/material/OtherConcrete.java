package kr.or.ddit.basetech.designpattern.adapter.material;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OtherConcrete implements Target {

	@Override
	public void request() {
		log.info("{}에서 요청을 처리했음.", this.getClass().getSimpleName());
	}

}
