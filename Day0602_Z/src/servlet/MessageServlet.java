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
		
		if(uri.equals(contextPath+"/messageList")) {
//			req.setAttribute("mList", service.list());
//			req.getRequestDispatcher("messageList.jsp").forward(req, resp);
//위는 기존 아래는 페이징
			int pageNumber = 1;
			if(req.getParameter("page")!=null) {
				pageNumber = Integer.parseInt(req.getParameter("page"));
			}
			req.setAttribute("messageList", service.getMessageList(pageNumber));
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
//		else if(uri.equals(contextPath+"/messageList")) {
//			req.setAttribute("mList", service.list());
//			req.getRequestDispatcher("messageList.jsp").forward(req, resp);
//		}
		else if(uri.equals(contextPath+"/confirmDeletion")) {
			req.getRequestDispatcher("confirmDeletion.jsp").forward(req, resp);
		}else if(uri.equals(contextPath+"/pwCheck")) {
			//게시글 번호를 가지고 오고, 해당 비번과 입력받은 비번이 일치하는지 확인.
			//일치하면 삭제
			int id = Integer.parseInt(req.getParameter("id"));
			String password = req.getParameter("password");
			String msg;
			if(service.del(id, password)) {
				msg="삭제 완료";
			} else {
				msg="삭제 실패";
			}
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("result.jsp").forward(req, resp);
		}
	}
	
	
}
