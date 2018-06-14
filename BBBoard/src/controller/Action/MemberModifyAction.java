package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class MemberModifyAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao dao = MemberDaoImp.getInstance();
		String id = req.getParameter("id");
		String userId = ((HttpServletRequest)req).getSession().getAttribute("userId").toString();
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
				result = dao.updateMember(m,userId);
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
		} else if(result<0) {
			msg = "본인의 정보만 수정할 수 있습니다!";
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
