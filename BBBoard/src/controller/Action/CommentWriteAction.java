package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.CommentDaoImp;
import dao.MemberDao;
import dao.MemberDaoImp;
import model.Comment;

public class CommentWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentDao dao = CommentDaoImp.getInstance();
		MemberDao mDao = MemberDaoImp.getInstance();
		Comment c = new Comment();
		String userId = req.getSession().getAttribute("userId").toString();
		String name = mDao.selectMember(userId).getName();
		c.setNum(Integer.parseInt(req.getParameter("num")));
		c.setWriterId(userId);
		c.setName(name);
		c.setText(req.getParameter("text"));
		int resultInt = dao.insertComment(c);
		boolean result = false;
		String data="";
		if(resultInt>0) {
			result = true;
			data = "{\"result\" : true}";
		}else if(resultInt<0) {
			//다른 사람 아이디 접근안됨!
			data = "{\"result\" : false}";
		}else {
			//입력 실패
			data = "{\"result\" : false}";
		}
		resp.getWriter().print(data);
	}
}
