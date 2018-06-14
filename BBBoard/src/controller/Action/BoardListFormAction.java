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
	private static final int NUM_OF_BOARD_PER_PAGE = 3;
	private static final int NUM_OF_NAVI_PAGE = 3;
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/boardList.jsp";
		BoardDao dao = BoardDaoImp.getInstance();
		//현재 페이지 번호
		int pageNumber=0;
		int firstRow=0;
		int endRow=0;
		int totalCount=0;
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
		//보여줄 페이지 (5페이지 단위 설정)
		//1~5페이지 = 5페이지까지
		//6~10페이지 = 10페이지까지 이런식으로..
		int minPage = 1;
		int maxPage = 1;
		for(int i=1; i<pageNumber+1; i++) {
			int tmp = i+4;
			if((tmp)%5 == 0) {
				if(tmp>totalCount) {
					maxPage = totalCount;
				}else {
					maxPage = tmp;
				}
			}
			if(i%5==1 && minPage<=maxPage) {
				minPage = i;
			}
		}
		System.out.println("민페:"+minPage);
		System.out.println("맥페:"+maxPage);
		List<Board> boardList = dao.selectAllBoard(firstRow, endRow);
		req.setAttribute("boardList", boardList);
		req.setAttribute("pageTotalCount", calPageTotalCount(totalCount));
		req.setAttribute("minPage", minPage);
		req.setAttribute("maxPage", maxPage);
		req.setAttribute("startPage", getStartPage(pageNumber));
		req.setAttribute("nowPage", pageNumber);
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
