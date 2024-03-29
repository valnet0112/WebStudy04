package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.others.dao.OthersDAO;
import kr.or.ddit.others.dao.OthersDAOImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class OthersDAOTest {
	
	OthersDAO dao = new OthersDAOImpl();

	@Test
	void testSelectLprodList() {
		dao.selectLprodList().stream()
			.forEach(m->log.info("lprod : {}", m));
	}

	@Test
	void testSelectBuyerList() {
		dao.selectBuyerList().stream()
			.forEach(m->log.info("buyer : {}", m));
	}

}
