package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

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
