package kr.or.ddit.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.exception.AuthenticateException;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor //한개만 final 을 붙일경우 authService는 따로 주입해줘야함
public class MemberServiceImpl implements MemberService{
	
	private final MemberDAO dao;
	@Inject
	private AuthenticateService authService; //서비스는 또다른형태의 서비스를 사용 할 수 있음.

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		if(dao.selectMember(member.getMemId())==null) {
			result = dao.insertMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
	}

	@Override
	public MemberVO retrieveMember(String memId) {
		MemberVO member = dao.selectMember(memId);
		if(member==null)
			throw new PKNotFoundException(String.format("%s 에 해당하는 사용자 없음.", memId));
		return member;
	}

	
	@Override
	public List<MemberVO> retrieveMemberList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectMemberList(paging);
	}
	
	

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		ServiceResult result = null;
		try {
			authService.authenticate(member);
			result = dao.updateMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (AuthenticateException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) {
		ServiceResult result = null;
		try {
			authService.authenticate(inputData);
			result = dao.deleteMember(inputData.getMemId()) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (AuthenticateException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

}












