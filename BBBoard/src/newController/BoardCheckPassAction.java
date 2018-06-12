package newController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardCheckPassAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		String pw = req.getParameter("pass");
		BoardDao dao = BoardDaoImp.getInstance();
		Board b = dao.selectBoard(num);
		String url = "";
//		if(pw.equals(b.getPass())) {
//			//삭제
//			url = "JSP/checkSuccess.jsp";
//		}else {
//			//비번 틀림
//			url = "JSP/boardCheckPass.jsp";
//			req.setAttribute("msg", "비밀번호가 틀립니다");
//		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
