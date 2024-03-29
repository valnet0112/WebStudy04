package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.BuyerVO;

/**
 * 제조사(거래처) 관리 Persistence Layer
 *
 */
@Mapper
public interface BuyerDAO {
	/**
	 * 제조사 조회
	 * @param buyerId
	 * @return 없으면, null 반환
	 */
	public BuyerVO selectBuyer(@Param("buyerId") String buyerId);
	/**
	 * 검색 조건에 해당하는 제조사 개수 조회
	 * @param paging
	 * @return
	 */
	public int selectTotalRecord(PaginationInfo paging);
	/**
	 * 검색 조건에 해당하는 제조사 목록을 대상으로 페이지 단위 조회
	 * @param paging
	 * @return
	 */
	public List<BuyerVO> selectBuyerList(PaginationInfo paging);
	
	/**
	 * 신규 제조사(거래처) 등록
	 * @param buyer
	 * @return
	 */
	public int insertBuyer(BuyerVO buyer);
	/**
	 * 제조사 수정
	 * @param buyer
	 * @return
	 */
	public int updateBuyer(BuyerVO buyer);
	
	// 제조사 삭제 처리는 지원할 수 없음. 
	// 대신 거래 중지 설정 여부를 표현하는 상태 컬럼이 있다면 처리 가능함.
}
