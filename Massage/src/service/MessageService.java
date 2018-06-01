package service;

import java.util.List;

import dao.MessageDao;
import model.Message;

public class MessageService {
	MessageDao dao;
	
	public MessageService() {
		 dao = new MessageDao();
	}
	
	public boolean add(Message m) {
		if(m.getPassword()==null || m.getName()==null || m.getMessage()==null) {
			System.out.println("실패");
			return false;
		}
		else {
			System.out.println("성공");
			dao.insert(m);
			return true;
		}
	}
	
	public List<Message> list() {
		if(dao.selectAll().size()>0) {
			return dao.selectAll();
		}
		return null;
	}
}