package kr.or.ddit.common.paging;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PaginationInfoTest {

	@Test
	void test() {
		PaginationInfo paging = new PaginationInfo();
		paging.setTotalRecord(101);
		paging.setCurrentPage(10);
		log.info("total page : {}", paging.getTotalPage());
		log.info("pagination : {}", paging);
	}

}
