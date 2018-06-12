package controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardListFormAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardList.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		List<Board> boardList = dao.selectAllBoard();
		
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
