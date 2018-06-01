package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;

public class MessageServlet extends HttpServlet {
	MessageService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProg(req, resp);
	}
	
	protected void doProg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String contextPath = req.getContextPath();
		String uri = req.getRequestURI();
		System.out.println("시동!");
		
		if(uri.equals(contextPath+"/messageList")) {
			req.setAttribute("mList", service.list());
			req.getRequestDispatcher("messageList.jsp").forward(req, resp);
		}else if(uri.equals(contextPath+"/write")) {
			Message m = new Message();
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String message = req.getParameter("message");
			m.setPassword(password);
			m.setName(name);
			m.setMessage(message);
			if(service.add(m)) {
				resp.sendRedirect("messageList");
			} else {
				System.out.println("안됨");
			}
		}
	}
}
