package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리(CRUD) Business Logic Layer
 *
 */
public interface ProdService {
	/**
	 * 상품 등록
	 * @param prod 상품 코드와 입고일을 제외한 신규 등록 상품 정보 VO, 등록시 상품 코드 생성 절차가 필요함.
	 * @return OK, FAIL
	 */
	public ServiceResult createProd(ProdVO prod);
	/**
	 * 페이징과 상세 검색 서비스를 지원하는 상품 목록 조회
	 * @param paging
	 * @return
	 */
	public List<ProdVO> retrieveProdList(PaginationInfo paging);
	/**
	 * 상품 상세 조회
	 * @param prodId
	 * @return 없으면, {@link PKNotFoundException}
	 */
	public ProdVO retrieveProd(String prodId);
	/**
	 * 상품 수정
	 * @param prod
	 * @return OK, FAIL
	 */
	public ServiceResult modifyProd(ProdVO prod);
}
