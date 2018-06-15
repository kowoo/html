package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import dao.CommentDao;
import dao.CommentDaoImp;
import model.Comment;

public class CommentDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CommentDao dao = CommentDaoImp.getInstance();
		BoardDao dao2 = BoardDaoImp.getInstance();
		String userId = req.getSession().getAttribute("userId").toString();
		System.out.println(userId);
		String count = req.getParameter("count");
		int num = dao.selectComment(count).getNum();
		int result = dao.deleteComment(userId, count);
		String data="";
		if(result>0) {
			//삭제 완료
			System.out.println("넘"+num);
			String number = String.valueOf(num);
			System.out.println("넘버"+number);
			dao2.downComment(number);
			data = "{\"result\" : true}";
		}else if(result<0) {
			//다른 사람 아이디 접근안됨!
			data = "{\"result\" : false}";
		}else {
			//실패
			data = "{\"result\" : false}";
		}
		resp.getWriter().print(data);
	}
}
