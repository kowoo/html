package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardModifyAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		Board board = new Board();
		board.setNum(Integer.parseInt(req.getParameter("num")));
		board.setName(req.getParameter("name"));
		board.setPass(req.getParameter("pass"));
		board.setEmail(req.getParameter("email"));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		int result = dao.updateBoard(board);
		//String url="";
		if(result>0) {
			//수정완료
			req.setAttribute("msg", "수정 완료");
		}else {
			//수정실패
			req.setAttribute("msg", "수정 실패");
		}
		req.setAttribute("url", "board_list");
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);
	}
}
