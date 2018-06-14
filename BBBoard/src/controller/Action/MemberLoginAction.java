package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;

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
				req.getSession().setAttribute("userName", dao.selectMember(id).getName());
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

