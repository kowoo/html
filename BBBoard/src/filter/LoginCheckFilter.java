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

public class LoginCheckFilter implements Filter {
	@Override
	public void destroy() {
		System.out.println("펑!!!!!");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("로그인 체크 필터");
		if(((HttpServletRequest)req).getSession().getAttribute("userId")!=null) {
			chain.doFilter(req, resp);
		} else {
			((HttpServletResponse)resp).sendRedirect("loginForm");
		}
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
