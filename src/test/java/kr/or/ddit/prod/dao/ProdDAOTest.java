package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class ProdDAOTest {
	@Inject
	ProdDAO dao;

	@Test
	void testInsertProd() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectTotalRecord() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectProdList() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectProd() {
		 ProdVO prod = dao.selectProd("P101000001");
		 assertNotNull(prod);
		 assertNotNull(prod.getLprod());
		 log.info("prod : {}", prod);
	}

	@Test
	void testUpdateProd() {
		fail("Not yet implemented");
	}

}










