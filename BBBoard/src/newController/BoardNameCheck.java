package newController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;

public class BoardNameCheck implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		MemberDao dao = MemberDaoImp.getInstance();
		String result=null;
		if(dao.selectMember(name)!=null) {
			result = "{\"msg\" : \"아이디가 존재함\"}";
		}
		resp.getWriter().print(result);
	}
}
