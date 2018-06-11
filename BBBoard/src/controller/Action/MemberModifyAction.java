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
		String pw = req.getParameter("pass");
		Member m = new Member();
		m.setId(req.getParameter("id"));
		m.setPw(req.getParameter("pass"));
		m.setName(req.getParameter("name"));
		m.setEmail(req.getParameter("email"));
		int result=0;
		String msg="";
		String url="";
		if(dao.selectMember(id)!=null) {
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
			
		}
		else {
			//수정 실패
		}
		
	}
}
