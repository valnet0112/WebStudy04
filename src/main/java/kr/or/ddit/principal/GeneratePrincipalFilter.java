package kr.or.ddit.principal;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

/**
 * 인증된 사용자(sessionscope 내의 authMember 속성을 가진)의 경우,
 * 해당 인증 객체를 Principal 구현체로 전환하기 위한 필터.
 * 원본 요청을 principal 의 구현체를 가진 wrapper request 로 변환하는 작업이 필요함.
 *
 */
public class GeneratePrincipalFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	private static class GeneratePrincipalHttpServletRequestWrapper extends HttpServletRequestWrapper{

		public GeneratePrincipalHttpServletRequestWrapper(HttpServletRequest request) {
			super(request);
		}
		@Override
		public Principal getUserPrincipal() {
			HttpSession session = getSession(false);
			if(session!=null && !session.isNew()) {
				MemberVO authMember = (MemberVO) session.getAttribute("authMember");
				if(authMember!=null) {
					MemberVOWrapper principal = new MemberVOWrapper(authMember);
					return principal;
				}
			}
			return super.getUserPrincipal();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		chain.doFilter(new GeneratePrincipalHttpServletRequestWrapper(req), response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
