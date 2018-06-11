package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardModifyFormAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardModify.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		req.setAttribute("title", dao.selectBoard(req.getParameter("num")).getTitle());
		req.setAttribute("board", dao.selectBoard(req.getParameter("num")));
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
