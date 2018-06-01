package servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doProg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id="asdf";
		String pw="1234";
		
		String uid = req.getParameter("userid");
		String upw = req.getParameter("userpw");
		
		if(uid!=null && uid.equals(id) && upw.equals(pw)) {
			Cookie cookie = new Cookie("userid",uid);
			resp.addCookie(cookie);
			resp.sendRedirect("main");
		} else {
			resp.sendRedirect("02loginForm.jsp");
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}
}
