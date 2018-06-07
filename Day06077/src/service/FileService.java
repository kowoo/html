package service;

import java.util.List;

import dao.Dao;

public class FileService {
	Dao dao;
	private static FileService instance;
	private FileService() {
		dao = Dao.getInstance();
	}
	public static FileService getInstance() {
		if(instance==null) {
			instance = new FileService();
		}
		return instance;
	}
	public boolean upload(String name) {
		int result = dao.insert(name);
		if(result > 0) {
			return true;
		} else {
			return false;
		}
	}
	public List<String> getAllFileNames() {
		return dao.selectAll();
	}
}
