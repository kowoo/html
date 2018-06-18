package controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CommentDao;
import dao.CommentDaoImp;
import model.Comment;

public class CommentListFormAction  implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		CommentDao dao = CommentDaoImp.getInstance();
		String num = req.getParameter("num");
		List<Comment> commentList = dao.selectAllCommentbyBoard(num);
		req.setAttribute("size",(commentList.size()));
		String result = new Gson().toJson(commentList);
		resp.getWriter().println(result);
	}
}
