package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.FileService;

public class UploadServlet extends HttpServlet {
	FileService service;
	
	public UploadServlet() {
		service = FileService.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		/*
		 * 요청이 들어오면 해야할 일
		 * 1. 제대로된 요청인지 확인 (파일업로드 요청인지 아닌지)
		 *     컨텐트 타입 가져와서 확인
		 * 2. 파일이름을 DB에 저장하고
		 * 3. multipart로 전달 받은 데이터를 파일로 만들어서 저장
		 * 
		 * */
		//1.요청 내용확인을 위해 contype 가져오기
		String contentType = req.getContentType();
		if(contentType!=null && contentType.toLowerCase().startsWith("multipart/")) {
			System.out.println("파일 업로드 요청 받음");
			//파일 업로드 요청을 받았으니 이름을 DB에 저장.
			saveFilename(req,resp);
		}
	}
	
	private void saveFilename(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파일들은 파트들로 분리되서 전송이 되기 때문에
		//파일들을 모두 모아서 파일로 만들어 저장

		//같은 이름을 가진 파일이 있으면 데이터 베이스에 저장이 되지 않거나 덮어씌우는 문제가 발생하거나 서버에서 문제가 발생할 수 있다.
		//그렇기 때문에 업로드 되는 파일 이름을 중복되지 않도록 만들어야한다 : UUID를 이용
		
		
		
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				UUID uuid = UUID.randomUUID();
				String saveName = uuid.toString()+"_"+fileName;
				//System.out.println("fileName:"+fileName);
				if(part.getSize()>0) {
					//파일 저장경로
					//part.write("C:\\temp\\"+fileName);
					//web.xml에 기본 경로 지정했을 경우 (<location>c:\temp</location>)
					part.write(saveName);
					//파일 네임을 DB에 저장
					service.uploadFile(saveName);
				}
			}
		}
		
	}
	
	
}
