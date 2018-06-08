package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action.Action;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
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
		//if-else if 방식이 아닌 요청 별로 새로운 클래스를 만들어서 작성!
		//동적 바인딩
		//ActionFactory: 실제 요청을 처리할 클래스의 객체를 만들어주는 역할이다.
		//실제로 우리가 호출하는 메서드는 Action execute만 호출한다.
		
		//실제 객체를 만들어주는 기능을 하는 클래스 작성
		//ActionFactory: action 객체를 만들어줌!
		
		String command = req.getParameter("command");
		Action action = ActionFactory.getAction(command);
		action.execute(req, resp);
	}
}
