package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.CommentDaoImp;
import model.Comment;

public class CommentDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentDao dao = CommentDaoImp.getInstance();
//		Member m=null;
//		if(dao.selectMember(req.getSession().getAttribute("userId").toString())!=null) {
//			m = dao.selectMember(req.getSession().getAttribute("userId").toString());
//			System.out.println(m);
//		}
//		String url = "JSP/boardWrite.jsp";
//		req.setAttribute("name", m.getName());
//		req.setAttribute("userId", req.getSession().getAttribute("userId"));
//		req.getRequestDispatcher(url).forward(req, resp);
	}
}
