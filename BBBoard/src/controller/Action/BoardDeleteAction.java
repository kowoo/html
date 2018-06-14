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
		BoardDao dao = BoardDaoImp.getInstance();
		String userId = ((HttpServletRequest)req).getSession().getAttribute("userId").toString();
		String num = req.getParameter("num");
		int result = dao.deleteBoard(num,userId);
		String msg = "";
		String url = "board?command=board_list";
		if(result>0) {
			//삭제 성공
			msg = "삭제 하였습니다.";
		}else if(result<0){
			msg = "본인이 작성한 글만 삭제할 수 있습니다.";
		}else {
			//삭제 실패
			msg = "삭제 실패...";
		}
		req.setAttribute("url", url);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
	}
}
