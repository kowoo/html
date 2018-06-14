package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import dao.MemberDao;
import dao.MemberDaoImp;

public class IdCheckFilter2 implements Filter {
	@Override
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("아이디 체크 필터2");
		//회원 정보, 수정 시 타인의 정보를 수정하거나 탈퇴할 수 없도록 만드는 필터
		MemberDao dao = MemberDaoImp.getInstance();
		String updateId = ((HttpServletRequest)req).getParameter("id");
		System.out.println("업데이트할 아이디 : "+updateId);
		String loginUserId = ((HttpServletRequest)req).getSession().getAttribute("userId").toString();
		System.out.println("로그인 한 유저의 아이디 : "+loginUserId);
		if(updateId.equals(loginUserId)) {
			chain.doFilter(req, resp);
		} else {
			((HttpServletRequest)req).setAttribute("msg", "타인의 정보는 수정할 수 없어요!");
			((HttpServletRequest)req).setAttribute("url", "board?command=board_list");
			((HttpServletRequest)req).getRequestDispatcher("JSP/result.jsp").forward(req, resp);
			//((HttpServletResponse)resp).sendRedirect("board?command=board_list");
		}
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
