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
		String url = "jsp/boardModify.jsp";
		
		BoardDao dao = BoardDaoImp.getInstance();
		req.setAttribute("board", dao.selectOne(req.getParameter("num")));
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
