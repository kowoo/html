//package servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import service.MemberService;
//
//@WebServlet("/check")
//public class LoginCheckServlet extends HttpServlet {
//	MemberService service;
//
//	protected void doProg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("여기도 안오냐1");
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		String result=null;
//		service = new MemberService();
//		System.out.println("여기도 안오냐2");
//		if(service.idCheck(req.getParameter("userid"))!=null){
//			result="{\"result\" : \"false\"}";
//			System.out.println("여기도 안오냐3");
//		} else {
//			result="{\"result\" : \"true\"}";
//			System.out.println("여기도 안오냐4");
//		}
//		String data = req.getParameter("userid");
//		System.out.println("여기도 안오냐5");
//		resp.getWriter().print(result);
//		System.out.println("여기도 안오냐6");
//		
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doProg(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doProg(req, resp);
//	}
//	
//}
