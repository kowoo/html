package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FileService;

public class UploadServlet extends HttpServlet{
	FileService service;
	
	public UploadServlet() {
		service = FileService.getInstance();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String contentType = req.getContentType();
		if(contentType!=null && contentType.toLowerCase().startsWith("multipart/")) {
			//파일 업로드 요청을 받은게 맞다면 이름을 DB에 저장한다.
			
		}
	}
}