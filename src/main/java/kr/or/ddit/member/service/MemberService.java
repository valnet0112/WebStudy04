package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

/**
 * 회원 관리(crud)용 business logic layer
 *
 */
public interface MemberService {
	/**
	 * 회원 가입 처리
	 * @param member
	 * @return PKDUPLICATED, OK, FAIL
	 */
	public ServiceResult createMember(MemberVO member);
	/** 
	 * 회원 정보 상세 조회
	 * @param memId 조회할 회원의 primary key 
	 * @return 존재하지 않는 경우, {@link PKNotFoundException}
	 */
	public MemberVO retrieveMember(String memId);
	/**
	 * 회원 목록 조회(관리자 용)
	 * totalRecord 와 페이징 처리 결과 데이터 목록 조회
	 * @param paging TODO
	 * @return
	 */
	public List<MemberVO> retrieveMemberList(PaginationInfo paging);
	
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return INVALIDPASSWORD, OK, FAIL
	 */
	public ServiceResult modifyMember(MemberVO member);
	/**
	 * 회원 탈쾨
	 * @param inputData
	 * @return INVALIDPASSWORD, OK, FAIL
	 */
	public ServiceResult removeMember(MemberVO inputData);
}
















