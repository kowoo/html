package controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardListAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDao dao = BoardDaoImp.getInstance();
		List<Board> boardList = dao.selectAll();
		
		req.setAttribute("boardList", boardList);
		req.getRequestDispatcher("jsp/boardList.jsp").forward(req, resp);
		//localhost:8081/contextpath/요청 의 형식
		//localhost:8081/contextpath/board
		//그냥 포워딩을 하게 되면 localhost:8081/contextpath의 /boardList.jsp로 가게됨.
		//근데 우리는 폴더 안에 jsp를 넣었으니까 jsp/boardList.jsp를 해줘야한다. 
	}
}
