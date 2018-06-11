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
		Board b = new Board();
		b.setName(req.getParameter("name"));
		b.setPass(req.getParameter("pass"));
		b.setTitle(req.getParameter("title"));
		b.setContent(req.getParameter("content"));
		int result = dao.insertBoard(b);
		String msg = "";
		String url = "";
		if(result>0) {
			msg = "등록 완료";
			url = "board?command=board_list";
		} else {
			msg = "등록 실패";
			url = "board?command=board_write_form";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
		
	}
}
