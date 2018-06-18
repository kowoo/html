package controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardSearchAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardList.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		String opt = req.getParameter("opt");
		String keyword = req.getParameter("keyword");
		System.out.println(opt);
		System.out.println(keyword);
		List<Board> list = dao.searchBoards(opt, keyword);
		System.out.println(list);
		req.setAttribute("boardList", list);
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
