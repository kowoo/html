package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ColorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}
	
	protected void doProg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("color");
		
		switch(param) {
		case "1":
			req.setAttribute("msg", "빨강");
			req.setAttribute("color", "red");
			break;
		case "2":
			req.setAttribute("msg", "파랑");
			req.setAttribute("color", "blue");
			break;
		case "3":
			req.setAttribute("msg", "초록");
			req.setAttribute("color", "green");
			break;
		default:
			break;
		}
		req.getRequestDispatcher("04colorSelect.jsp").forward(req, resp);
	}
	
}
