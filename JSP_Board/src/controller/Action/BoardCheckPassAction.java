package controller.Action;

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
		String pass = req.getParameter("pass");
		BoardDao dao = BoardDaoImp.getInstance();
		
		//파라미터에서 게시글 번호, 비밀번호를 가져와서
		//해당 번호 글의 비밀번호와 입력받은 비밀번호가 같으면 수정화면으로 이동, 아니면 비번 입력란으로
		Board board = dao.selectOne(num);
		String url = "";
		if(board.getPass().equals(pass)) {
			//비번 맞음 수정 ㄱ
			url = "jsp/checkSuccess.jsp";
		} else {
			//비번 틀림 비번창 ㄱ
			url = "jsp/boardCheckPass.jsp";
			req.setAttribute("msg", "비밀번호 불일치");
		}
		req.getRequestDispatcher(url).forward(req, resp);
		
		//파라미터에서 게시글 번호, 비밀번호를 가져와서
		//해당 번호 글의 비밀번호와 입력받은 비밀번호가 같으면 수정화면으로 이동, 아니면 비번 입력란으로
		
		
		
		
	}
}
