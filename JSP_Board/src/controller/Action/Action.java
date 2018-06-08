package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	//이런 액션들을 처리클래스, 핸들러라고 한다
}
