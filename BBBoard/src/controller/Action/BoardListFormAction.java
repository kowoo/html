package controller.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardListFormAction implements Action {
	private static final int NUM_OF_BOARD_PER_PAGE = 5;
	private static final int NUM_OF_NAVI_PAGE = 5;
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardList.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		//현재 페이지 번호
		int pageNumber =0;
		int firstRow = 0;
		int endRow =0;
		int totalCount = 0;
		String staPageNumber = req.getParameter("page");
		
		if(staPageNumber!=null) {
			pageNumber = Integer.parseInt(staPageNumber);
		}
		if(pageNumber<1) {
			pageNumber = 1;
		}
		System.out.println("현재 페이지:" +pageNumber);
		
		totalCount = dao.boardCount();
		firstRow = (pageNumber-1)*NUM_OF_BOARD_PER_PAGE+1;
		endRow = pageNumber*NUM_OF_BOARD_PER_PAGE;
		
		List<Board> boardList = dao.selectAllBoard(firstRow, endRow);
		req.setAttribute("boardList", boardList);
		req.setAttribute("pageTotalCount", calPageTotalCount(totalCount));
		req.setAttribute("startPage", getStartPage(pageNumber));
		req.setAttribute("endPage", getEndPage(pageNumber));
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
	private int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if(totalCount!=0) {
			pageTotalCount = (int)Math.ceil(((double)totalCount / NUM_OF_BOARD_PER_PAGE));
		}
		return pageTotalCount;
	}
	public int getStartPage(int pageNum) {
		int startPage = ((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE+1;
		return startPage;
	}
	public int getEndPage(int pageNum) {
		int endPage = (((pageNum-1)/NUM_OF_NAVI_PAGE)+1)*NUM_OF_NAVI_PAGE;
		return endPage;
	}
}
