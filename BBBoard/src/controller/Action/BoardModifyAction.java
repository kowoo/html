package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardModifyAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = BoardDaoImp.getInstance();
		String userId = ((HttpServletRequest)req).getSession().getAttribute("userId").toString();
		Board b = dao.selectBoard(req.getParameter("num"));
		b.setTitle(req.getParameter("title"));
		b.setContent(req.getParameter("content"));
		b.setNum(Integer.parseInt(req.getParameter("num")));
		int result = dao.updateBoard(b, userId);
		String url = "board?command=board_view&num="+b.getNum();
		String msg="";
		if(result>0) {
			//수정완료
			msg = "수정 완료";
		}else if(result<0) {
			msg = "본인이 작성한 글만 수정할 수 있습니다.";
		}else {
			//수정실패
			msg = "수정 실패";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
	}
}
