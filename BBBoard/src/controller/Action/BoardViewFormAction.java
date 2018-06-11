package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardViewFormAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardView.jsp";
		String num = req.getParameter("num");
		BoardDao dao = BoardDaoImp.getInstance();
		req.setAttribute("title", dao.selectBoard(num).getTitle());
		req.setAttribute("board", dao.selectBoard(num));
		req.setAttribute("boardList", dao.selectAllBoard());
		req.getRequestDispatcher(url).forward(req, resp);
		
		
	}
}
