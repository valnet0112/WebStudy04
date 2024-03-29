package kr.or.ddit.others.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 동적 UI 생성에 필요한 데이터 조회 Persistence layer
 *
 */
@Mapper
public interface OthersDAO {
	/**
	 * 전체 상품 분류 조회
	 * @return
	 */
	public List<Map<String, Object>> selectLprodList();
	/**
	 * 전체 제조사 목록 조회
	 * @return
	 */
	public List<Map<String, Object>> selectBuyerList();
}
