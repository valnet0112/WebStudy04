package kr.or.ddit.validate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
class BuyerVOValidateTest {
	static Validator validator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@Test
	void test() {
		BuyerVO target = new BuyerVO();
		Set<ConstraintViolation<BuyerVO>> constraintViolations = validator.validate(target, InsertGroup.class);
		log.info("검증 통과 여부 : {}", constraintViolations.isEmpty());
		log.info("검증 통과하지 못한 프로퍼티수 : {}", constraintViolations.size());
		constraintViolations.stream()
			.forEach(v->{
				String propPath = v.getPropertyPath().toString();
			 	String message = v.getMessage(); 
				log.info("{} : {}", propPath, message);
			});
		
		Map<String, String> errors = constraintViolations.stream()
									.collect(Collectors.toMap((v)->{return v.getPropertyPath().toString();}, (v)->{return v.getMessage();}));
		log.info("errors : {}", errors);
	}

}
