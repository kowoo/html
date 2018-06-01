package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -1511337217172506014L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("로그인 요청 받음");
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		String id = "abc";
		String pw = "1234";
		if(id.equals(userid)) {
			if(pw.equals(userpw)) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("03loginSuccess.jsp");
				dispatcher.forward(req, resp);
				System.out.println(id+"로그인");
				
			} else {
				System.out.println("비번 틀린 멍청이ㅋ");
				req.setAttribute("msg", "비밀번호가 틀렸습니다.");
				RequestDispatcher dispatcher
				= req.getRequestDispatcher("03loginFail.jsp");
				dispatcher.forward(req, resp);
			}
		} else {
			System.out.println("아이디 틀린 멍청이ㅋ");
			req.setAttribute("msg", "아이디가 틀렸습니다.");
			RequestDispatcher dispatcher
			= req.getRequestDispatcher("03loginFail.jsp");
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		//두겟으로 들어와도 두포스트로 처리하게 만들기
	}
}
