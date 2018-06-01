package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}
	protected void doProg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//두겟, 두포스트를 처리하는 메서드.
		req.setCharacterEncoding("UTF-8");
		String id = "abcd";
		String pw = "1234";
		String userId = req.getParameter("uid");
		String userPw = req.getParameter("upw");
		HttpSession session = req.getSession();
		
		if(userId.equals(id)) {
			if(userPw.equals(pw)) {
				System.out.println("로그인 성공");
				session.setAttribute("uid", userId);
				RequestDispatcher dispatcher = req.getRequestDispatcher("04main.jsp");
				dispatcher.forward(req, resp);
				resp.sendRedirect("main");
			} 
		}
		resp.sendRedirect("04loginForm.jsp");
	}
}
