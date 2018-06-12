package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;

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
