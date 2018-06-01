package filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NullParameterFilter implements Filter {
	String[] parameterNames;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("필터 동작합니다!");
		//필터가 수행할 동작을 작성
		//요청을 받아서 처리할 일이 있으면 처리하고, 다음 단계로 요청을 전달
		
		//처리할 일 : 요청 파라미터를 받아와서 id, name이라는 파라미터가 없으면 파라미터 만들어주기
		
		//요청이 가지고 있는 파라미터(id,name) 확인하고 없으면 추가
		NullParameterRequestWrapper requestWrapper = new NullParameterRequestWrapper((HttpServletRequest)req);
		requestWrapper.checkNull(parameterNames);
		
		//다음 단계로 요청을 전달하는 과정이다.
		chain.doFilter(requestWrapper, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String names = config.getInitParameter("parameterNames");
		System.out.println(names);
		//parameterNames에는 'id,name'형태로 문자열이 저장되어 있으니 사용하려면 잘라줘야함.
		StringTokenizer st = new StringTokenizer(names, ",");
		parameterNames = new String[st.countTokens()];
		
		for(int i=0; i<parameterNames.length; i++) {
			parameterNames[i] = st.nextToken();
		}
	}

}

