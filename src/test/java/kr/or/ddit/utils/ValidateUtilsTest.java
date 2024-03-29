package kr.or.ddit.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ValidateUtilsTest {

	@Test
	void test() {
		MemberVO member = new MemberVO();
		member.setMemHp("000-000-0000");
		member.setMemComtel("000-000-0000");
		member.setMemHometel("000-000-0000");
		
		Map<String, String> errors = new LinkedHashMap<>();
		boolean valid = ValidateUtils.validate(member, errors, InsertGroup.class);
		log.info("통과 여부 : {}, {}", valid, errors.isEmpty());
		log.info("검증 결과 : {}", errors.size());
		errors.forEach((k,v)->log.info("{}:{}", k,v));
	}

}













