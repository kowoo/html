package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		BoardDao dao = BoardDaoImp.getInstance();
		int result = dao.deleteBoard(num);
		String url = "";
		if(result>0) {
			//삭제 성공
			url = "JSP/boardList.jsp";
		}else {
			//삭제 실패
			url = "JSP/boardList.jsp";
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
