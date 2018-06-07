package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FileService;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
	FileService fileService;
	
	public FileServlet() {
		// service 객체 얻어오기: singleton
		fileService = FileService.getInstance();
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
		
		String command = req.getParameter("command");
		if(command!=null && command.equals("fileList")) {
			//파일리스트 출력
			System.out.println("여기 들어오니???");
			List<String> fileList = fileService.getAllFileNames();
			req.setAttribute("fileList", fileList);
			req.getRequestDispatcher("fileList.jsp").forward(req, resp);
		} else if (command!=null && command.equals("download")) {
			//파일 다운
			System.out.println("download 요청");
			String fileName = req.getParameter("filename");
			System.out.println("fileName  : " + fileName);
			
			//파일의 경로는 이미 알고 있기 떄문에 해당 경로에 가서 파일을 만들어 오면 된다.
			String downloadPath = "c:\\temp\\";
			
			//파일의 전체 경로
			String filePath = downloadPath+fileName;
			
			//파일 복사: FileInputStream 사용
			byte[] b = new byte[4096];
			FileInputStream fis = new FileInputStream(filePath);
			
			//응답에 실어서 전달을 할 때 파일의 종류를 알려줘야 한다.
			//파일의 종류 및 실행 어플리케이션에 대한 정의
			String sMimeType = getServletContext().getMimeType(filePath);
			//MIME : Multipurpose Internet Mail Extensions
			if(sMimeType==null) {
				sMimeType = "application/octect-stream";
			}
			resp.setContentType(sMimeType);
			//UUID 제거
			//UUID를 넣고 뒤에 언더바를 하나 넣어놨기 때문에 "_"로 UUID를 구분해서 제거
			int index = fileName.indexOf("_");
			String originFileName = fileName.substring(index+1);
			
			//한글 파일명 처리
			String strEncoding = new String(originFileName.getBytes("utf-8"),"8859_1");
			
			resp.setHeader("Content-Disposition", "attachment;filename="+strEncoding);
			
			ServletOutputStream servletOutputStream = resp.getOutputStream();
			int readNum = 0;
			
			while((readNum = fis.read(b,0,b.length)) != -1) {		
				servletOutputStream.write(b,0,readNum);
			}
			servletOutputStream.flush();
			servletOutputStream.close();
			fis.close();
		}
	}
}
