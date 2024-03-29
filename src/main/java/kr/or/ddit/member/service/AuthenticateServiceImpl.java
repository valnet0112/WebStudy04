package kr.or.ddit.member.service;

import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.exception.AuthenticateException;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor  //기본생성자를 없애서 인잭션으로 주입받기를 -> 유도함 final을 사용
public class AuthenticateServiceImpl implements AuthenticateService {
	private final MemberDAO dao;
	
	@Override
	public MemberVO authenticate(MemberVO inputData) {
		boolean auth = false;
		MemberVO saved = dao.selectMemberForAuth(inputData.getMemId());
		if(saved!=null) {
			String inputPass = inputData.getMemPass();
			String savedPass = saved.getMemPass();
			auth = savedPass.equals(inputPass);  //단순비교 암호화가 안되어있음 실제서비스 사용 x
		}
		if(!auth) throw new AuthenticateException(inputData.getMemId());
		return saved;
	}

}












