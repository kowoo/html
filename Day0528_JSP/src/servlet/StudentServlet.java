package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 7846483077033842270L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = new ArrayList<Student>();
		int snum = Integer.parseInt(req.getParameter("snum"));
		String name = req.getParameter("name");
		int grade = Integer.parseInt(req.getParameter("grade"));
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		
		Student s = new Student(snum, name, grade, kor, eng, math);
		list.add(s);
		
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("04studentResult.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
