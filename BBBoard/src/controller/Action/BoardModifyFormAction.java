package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardModifyFormAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardModify.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		Board b = dao.selectBoard(req.getParameter("num"));
		req.setAttribute("title", b.getTitle());
		req.setAttribute("board", b);
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
