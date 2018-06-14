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

public class IdCheckFilter implements Filter {
	@Override
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("아이디 체크 필터");
		//글 수정, 삭제, 덧글 삭제를 위한 필터
		//접속 중인 유저의 아이디와 해당 글, 덧글을 작성한 유저의 아이디가 일치하는지 확인하는 필터.
		BoardDao dao = BoardDaoImp.getInstance();
		String num = req.getParameter("num");
		String writerId = dao.selectBoard(num).getWriterId();
		String loginUserId = ((HttpServletRequest)req).getSession().getAttribute("userId").toString();
		if(writerId.equals(loginUserId)) {
			((HttpServletRequest)req).setAttribute("writer", "true");
			chain.doFilter(req, resp);
		} else {
			((HttpServletResponse)resp).sendRedirect("board?command=board_view&msg=no&num="+num);
		}
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
