package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import dao.CommentDao;
import dao.CommentDaoImp;

public class BoardViewFormAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardView.jsp";
		String num = req.getParameter("num");
		BoardDao dao = BoardDaoImp.getInstance();
		CommentDao dao2 = CommentDaoImp.getInstance();
		dao.upReadCount(num);
		req.setAttribute("title", dao.selectBoard(num).getTitle());
		req.setAttribute("board", dao.selectBoard(num));
		req.setAttribute("writerId", dao.selectBoard(num).getWriterId());
		req.setAttribute("boardList", dao.selectAllBoard());
		req.setAttribute("num", num);
		req.setAttribute("size", dao2.selectAllCommentbyBoard(num).size());
		//req.setAttribute("userId", req.getSession().getAttribute("userId").toString());
		req.getRequestDispatcher(url).forward(req, resp);
	}
}

