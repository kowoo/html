package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = new Board();
		board.setName(req.getParameter("name"));
		board.setPass(req.getParameter("pass"));
		board.setEmail(req.getParameter("email"));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		
		int result = dao.insertBoard(board);
		//String url ="";
		if(result>0) {
			req.setAttribute("msg", "작성 성공");
			//url="board?command=board_list";
			req.setAttribute("url", "board_list");
		} else {
			req.setAttribute("msg", "작성 실패");
			//url="board?command=board_write_form";
			req.setAttribute("url", "board_write_form");
		}
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);
	}
}
