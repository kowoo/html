package newController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.BoardDaoImp;
import dao.MemberDao;
import dao.MemberDaoImp;
import model.Board;
import model.Member;

public interface Action {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	//이런 액션들을 처리클래스, 핸들러라고 한다
	
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
			//System.out.println("현재 페이지:" +pageNumber);
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

	public class BoardWriteFormAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			MemberDao dao = MemberDaoImp.getInstance();
			Member m=null;
			if(dao.selectMember(req.getSession().getAttribute("userId").toString())!=null) {
				m = dao.selectMember(req.getSession().getAttribute("userId").toString());
				System.out.println(m);
			}
			String url = "JSP/boardWrite.jsp";
			req.setAttribute("name", m.getName());
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

	public class BoardWriteAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			BoardDao dao = BoardDaoImp.getInstance();
			Board b = new Board();
			b.setName(req.getParameter("name"));
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

	public class BoardViewFormAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String url = "JSP/boardView.jsp";
			String num = req.getParameter("num");
			BoardDao dao = BoardDaoImp.getInstance();
			dao.upReadCount(num);
			req.setAttribute("title", dao.selectBoard(num).getTitle());
			req.setAttribute("board", dao.selectBoard(num));
			req.setAttribute("boardList", dao.selectAllBoard());
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

	public class BoardModifyFormAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String url = "JSP/boardModify.jsp";
			BoardDao dao = BoardDaoImp.getInstance();
			req.setAttribute("title", dao.selectBoard(req.getParameter("num")).getTitle());
			req.setAttribute("board", dao.selectBoard(req.getParameter("num")));
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

	public class BoardModifyAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			BoardDao dao = BoardDaoImp.getInstance();
			Board b = new Board();
			b.setTitle(req.getParameter("title"));
			b.setContent(req.getParameter("content"));
			b.setNum(Integer.parseInt(req.getParameter("num")));
			int result = dao.updateBoard(b);
			String url = "board?command=board_view&num="+b.getNum();
			if(result>0) {
				//수정완료
				req.setAttribute("msg", "수정 완료");
			}else {
				//수정실패
				req.setAttribute("msg", "수정 실패");
			}
			req.setAttribute("url", url);
			req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
		}
	}

	public class BoardDeleteAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String num = req.getParameter("num");
			BoardDao dao = BoardDaoImp.getInstance();
			int result = dao.deleteBoard(num);
			String msg = "";
			String url = "board?command=board_list";
			if(result>0) {
				//삭제 성공
				msg = "삭제 하였습니다.";
			}else {
				//삭제 실패
				msg = "삭제 실패...";
			}
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
		}
	}

	public class MemberJoinFormAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String url="JSP/memberJoin.jsp";
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

	public class MemberJoinAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			MemberDao dao = MemberDaoImp.getInstance();
			Member m = new Member();

			m.setId(req.getParameter("id"));
			m.setPw(req.getParameter("pass"));
			m.setName(req.getParameter("name"));
			m.setEmail(req.getParameter("email"));

			int result = dao.insertMember(m);
			String url = "";
			String msg = "";
			if(result>0) {
				//가입 성공
				msg = "회원가입 성공";
				url = "board?command=member_login_form";
			}else {
				//가입 실패
				msg = "회원가입 실패";
				url = "member?command=member_join_form";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
		}
	}

	public class MemberLoginFormAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String url = "JSP/memberLogin.jsp";
			req.getRequestDispatcher(url).forward(req, resp);
		}
	}

	public class MemberLoginAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			String pw = req.getParameter("pass");
			MemberDao dao = MemberDaoImp.getInstance();
			String msg = "";
			String url = "";

			if(dao.selectMember(id)!=null) {
				System.out.println(dao.selectMember(id));
				System.out.println(dao.selectMember(id).getPw());
				if(pw.equals(dao.selectMember(id).getPw())) {
					//로그인 성공
					msg = "로그인 성공";
					url = "board?command=board_list";
					req.getSession().setAttribute("userId", id);
				}else {
					//로그인 실패
					msg = "아이디 혹은 비밀번호가 틀렸습니다.";
					url = "member?command=member_login_form";
				}
			}else {
				//로그인 실패
				msg = "아이디 혹은 비밀번호가 틀렸습니다.";
				url = "member?command=member_login_form";
			}
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
		}
	}

	public class MemberLogoutAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("board?command=board_list");
		}
	}

	public class MemberModifyFormAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//String url = "board?command=board_list";
			String id = req.getParameter("id");
			System.out.println(id);
			MemberDao dao = MemberDaoImp.getInstance();
			req.setAttribute("member", dao.selectMember(id));

			req.getRequestDispatcher("JSP/memberModify.jsp").forward(req, resp);
		}
	}

	public class MemberModifyAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			MemberDao dao = MemberDaoImp.getInstance();
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			Member m = new Member();
			m.setId(id);
			m.setPw(req.getParameter("pw2"));
			m.setName(req.getParameter("name"));
			m.setEmail(req.getParameter("email"));
			int result=0;
			String msg="";
			String url="";
			String url2="";
			//아이디 검사
			if(dao.selectMember(id)!=null) {
				//비밀번호 검사
				if(pw.equals(dao.selectMember(id).getPw())) {
					result = dao.updateMember(m);
				}else {
					//수정 실패
				}
			}else {
				//수정 실패
			}

			if(result>0) {
				//수정 성공
				msg = "회원 정보 변경 완료";
				url = "board?command=board_list";
				url2 = "JSP/result.jsp";
			}
			else {
				//수정 실패
				msg = "비밀번호를 확인해주세요!";
				url2 = "JSP/memberModify.jsp";
				req.setAttribute("member", dao.selectMember(id));
			}
			req.setAttribute("url", url);
			req.setAttribute("msg", msg);
			req.getRequestDispatcher(url2).forward(req, resp);
		}
	}

	public class MemberViewFormAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		}
	}

	public class MemberDeleteAction implements Action {
		@Override
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		}
	}
}
