package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class MemberViewFormAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "JSP/memberView.jsp";
		String name = req.getParameter("name");
		System.out.println(name);
		MemberDao dao = MemberDaoImp.getInstance();
		Member m = dao.selectMemberbyName(name);
		System.out.println(m);
		
		req.setAttribute("m", m);
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
