package service;
import java.util.List;

import dao.FileDao;
public class FileService {
	FileDao dao;
	
	private static FileService instance;
	
	public static FileService getInstance() {
		if(instance==null) {
			instance = new FileService();
		}
		return instance;
	}
	
	public FileService() {
		dao = FileDao.getInstance();
	}
	public boolean uploadFile(String fileName) {
		int result = dao.insertFile(fileName);
		if(result >0) {
			return true;
		}else {
			return false;
		}
	}
	public List<String> getAllFileNames() {
//		List<String> files;
//		files = dao.selectAll();
//		return files;
		return dao.selectAll();
	}
	
	
	
	
}
