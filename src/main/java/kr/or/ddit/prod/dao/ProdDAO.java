package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리(CRUD) Persistence Layer
 *
 */
@Mapper
public interface ProdDAO {
	/**
	 * 상품 신규 등록
	 * @param prod 상품 코드와 입고일을 제외한 신규 등록 상품 정보 VO
	 * @return 등록 성공시 > 0
	 */
	public int insertProd(ProdVO prod);
	
	/**
	 * totalRecord/totalPage 를 결정하기 위한 쿼리
	 * @param paging
	 * @return
	 */
	public int selectTotalRecord(PaginationInfo paging);
	/**
	 * 페이징 처리 결과 데이터 목록 조회
	 * @param paging
	 * @return
	 */
	public List<ProdVO> selectProdList(PaginationInfo paging); // 다건 조회
	
	/**
	 * 상품 상세 조회, 상품분류명과 제조사 정보를 동시 조회하며, Has A 관계 모델링 구조를 사용함.
	 * @param prodId
	 * @return
	 */
	public ProdVO selectProd(String prodId); // 단건 조회
	/**
	 * 상품 수정
	 * @param prod
	 * @return
	 */
	public int updateProd(ProdVO prod);
}
