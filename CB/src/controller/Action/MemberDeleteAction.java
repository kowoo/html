package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;

public class MemberDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao dao = MemberDaoImp.getInstance();
		String userId = ((HttpServletRequest)req).getSession().getAttribute("userId").toString();
		String id = ((HttpServletRequest)req).getParameter("id");
		int result = dao.deleteMember(id, userId);
		String msg = "";
		String url = "board?command=board_list";
		if(result>0) {
			//삭제 성공
			msg = "회원 탈퇴 완료.";
			req.getSession().invalidate();
		}else if(result<0){
			msg = "접근 불가";
		}else {
			//삭제 실패
			msg = "삭제 실패...";
		}
		req.setAttribute("url", url);
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("JSP/result.jsp").forward(req, resp);
	}
}
