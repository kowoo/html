package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.MemberService;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	MemberService service;
	
	public MemberServlet() {
		service = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doProc(req, resp);
	}
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//요청 구분 command 파라미터로 구분
		String command = req.getParameter("command");
		
		if(command.equals("hello")) {
			Map<String, String[]> parameters = req.getParameterMap();
			for(String key:parameters.keySet()) {
				System.out.println(key+" : "+parameters.get(key)[0]);
			}
		}else if(command.equals("checkId")) {
			String userid = req.getParameter("userid");
			String result =""; 
			Member member = service.getMember(userid);
			if(member!=null) {
				//아이디 사용 불가
				result = "{\"result\" : false}";
			}else {
				//아이디 사용 가능
				result = "{\"result\" : true}";
			}
			resp.getWriter().print(result);
		}else if(command.equals("checkEmail")) {
			String email = req.getParameter("email");
			String result ="";
			System.out.println(email);
			Member member = service.getMemberByEmail(email);
			if(member!=null) {
				//이메일 사용 불가
				result = "{\"result\" : false}";
			}else {
				//이메일 사용 가능
				result = "{\"result\" : true}";
			}
			resp.getWriter().print(result);
		}else if(command.equals("join")) {
			Member member = new Member();
			String id = req.getParameter("userid");
			String pw = req.getParameter("password");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setEmail(email);
			boolean join = service.join(member);
			String result;
			if(join) {
				result = "{\"result\" : true}";
			} else {
				result = "{\"result\" : false}";
			}
			resp.getWriter().print(result);
		}
		
//		System.out.println("Member요청 받았습니다!!!");
//		Map<String, String[]> parameters 
//		 = req.getParameterMap();
//		
//		for(String key:parameters.keySet()) {
//			System.out.println(key+" : "+parameters.get(key)[0]);
//		}
		
		//데이터 베이스에서 해당하는 아이디로 회원을 조회
		//결과를 받아서 결과에 따라 응답할 데이터를 만들어 낸다. 

		
	}
	
	
}






