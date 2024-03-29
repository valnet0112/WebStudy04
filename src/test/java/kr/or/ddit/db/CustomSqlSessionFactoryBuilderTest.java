package kr.or.ddit.db;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CustomSqlSessionFactoryBuilderTest {
	SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Test
	void testGetSqlSessionFactory() {
		log.info("sql session factory : {}", sqlSessionFactory);
	}

	@Test
	void testSqlSession() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			log.info("sqlSession : {}", sqlSession);
			MemberVO saved = sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMemberForAuth", "a001");
			log.info("saved : {}", saved);
		}
	}
	
	@Test
	void testMappedStatements() {
		sqlSessionFactory.getConfiguration().getMappedStatements().stream()
				.forEach(ms->{
					log.info("each statement : {}", ms.getId());
				});
	}
	
	@Test
	void testMapper() {
		sqlSessionFactory.getConfiguration().getMapperRegistry().getMappers().stream()
				.forEach(m->{
					log.info("each mapper : {}", m);
				});
	}
}













