package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;

public class MessageServlet extends HttpServlet {
	MessageService service = new MessageService();

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
			String url=null;
			String msg=null;
			Message m = new Message();
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String message = req.getParameter("message");
			
			m.setPassword(password);
			m.setName(name);
			m.setMessage(message);
			if(service.add(m)) {
				msg="작성 완료";
			} else {
				msg="작성 실패";
			}
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("result.jsp").forward(req, resp);
		}
	}
}
