package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

	protected void doProg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Board b = new Board();
		
		req.setCharacterEncoding("utf-8");
		b.setTitle(req.getParameter("title"));
		b.setName(req.getParameter("name"));
		b.setEmail(req.getParameter("email"));
		b.setPass(req.getParameter("pass"));
		b.setContent(req.getParameter("content"));
		
		req.getSession().setAttribute("board", b);
		RequestDispatcher dis = req.getRequestDispatcher("07boardInfo.jsp");
		dis.forward(req, resp);
		
		//resp.sendRedirect("07boardInfo.jsp");
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
