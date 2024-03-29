package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.BuyerVO;

/**
 * 제조사 관리 Business Logic Layer
 *
 */
public interface BuyerService {
	/**
	 * 제조사 상세 조회
	 * @param buyerId
	 * @return 없으면, 예외 발생
	 */
	public BuyerVO retrieveBuyer(String buyerId);
	
	/**
	 * 제조사 목록 조회
	 * 페이징과 검색 기능 지원 
	 * @param paging
	 * @return
	 */
	public List<BuyerVO> retrieveBuyerList(PaginationInfo paging);
	
	/**
	 * 제조사 신규 등록, 등록시 PK 생성 절차 필요.
	 * @param buyer
	 */
	public void createBuyer(BuyerVO buyer);
	
	/**
	 * 제조사 정보 수정
	 * @param buyer
	 */
	public void modifyBuyer(BuyerVO buyer);
}
