package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.MemberService;

public class MemberServlet extends HttpServlet {
	private MemberService service;
	
	public MemberServlet() {
		service = new MemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("URL:"+req.getRequestURI());
		//여기서 요청을 구분한다
		System.out.println("Context: "+ req.getContextPath());
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		if(uri.equals(contextPath+"/login")) {
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			System.out.println(id);
			if(service.login(id, pw)) {
				req.getSession().setAttribute("userid", id);
				req.getSession().setAttribute("user",service.call(id));
				resp.sendRedirect("main");
				//req.getRequestDispatcher("main.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
			}
		}else if(uri.equals(contextPath+"/loginForm")) {
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
		}else if(uri.equals(contextPath+"/logout")) {
			req.getSession().removeAttribute("userid");
			req.getSession().removeAttribute("user");
			resp.sendRedirect("loginForm");
		}else if(uri.equals(contextPath+"/main")) {
			if(req.getSession().getAttribute("userid")!=null) {
				req.getRequestDispatcher("main.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("loginForm");
			}
		}else if(uri.equals(contextPath+"/memberList")) {
			if(req.getSession().getAttribute("userid")!=null) {
				req.setAttribute("mList", service.memberAll());
				req.getRequestDispatcher("memberList.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("loginForm");
			}
		}else if(uri.equals(contextPath+"/join")) {
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			String name = req.getParameter("userName");
			String email = req.getParameter("userEmail");
			Member newMember = new Member();
			newMember.setId(id);
			newMember.setPw(pw);
			newMember.setName(name);
			newMember.setEmail(email);
			if(service.join(newMember)) {
				resp.sendRedirect("loginForm");
			} else {
				resp.sendRedirect("joinForm");
			}
		}else if(uri.equals(contextPath+"/joinForm")) {
			req.getRequestDispatcher("joinForm.jsp").forward(req, resp);
		}else if(uri.equals(contextPath+"/modifyForm")) {
			if(req.getSession().getAttribute("userid")!=null) {
				req.getRequestDispatcher("modifyForm.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
			}
		}else if(uri.equals(contextPath+"/modify")) {
			if(req.getSession().getAttribute("userid")!=null) {
				String id = (String)req.getSession().getAttribute("userid");
				String name = req.getParameter("userName");
				String pw = req.getParameter("userPw");
				String email = req.getParameter("userEmail");
				Member m = new Member();
				m.setId(id);
				m.setName(name);
				m.setPw(pw);
				m.setEmail(email);
				service.modify(m);
				
				resp.sendRedirect("main");
			}else {
				resp.sendRedirect("loginForm");
			}
		}else if(uri.equals(contextPath+"/dropForm")) {
			if(req.getSession().getAttribute("userid")!=null) {
				req.getRequestDispatcher("dropForm.jsp").forward(req, resp);
			}else {
				resp.sendRedirect("loginForm");
			}
		}else if(uri.equals(contextPath+"/drop")) {
			if(req.getSession().getAttribute("userid")!=null) {
				String id = req.getParameter("userId");
				String pw = req.getParameter("userPw");
				if(service.drop(id, pw)) {
					resp.sendRedirect("logout");
				}else {
					resp.sendRedirect("main");
				}
			}else {
				resp.sendRedirect("loginForm");
			}
		}
	}
}
