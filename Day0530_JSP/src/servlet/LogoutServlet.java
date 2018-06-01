package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doProg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id="asdf";
		String uid = req.getParameter("userid");
		
		if(uid!=null && uid.equals(id)) {
			Cookie cookie = new Cookie("userid",uid);
			cookie.setMaxAge(0);
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
