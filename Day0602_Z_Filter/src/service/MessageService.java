package service;

import java.util.List;

import dao.MessageDao;
import model.Message;

public class MessageService {
	private static MessageService instance;
	private MessageDao dao;
	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
		
	public MessageService() {
		dao = MessageDao.getInstance();
	}
	
	public boolean add(Message m) {
		if(m.getPassword().equals("") || m.getMessage().equals("")) {
			System.out.println("실패");
			return false;
		}
		else {
			System.out.println("성공");
			dao.insertMessage(m);
			return true;
		}
	}
	
	public boolean del(int id, String pw) {
		if(dao.selectOne(id)!=null) {
			Message tmp = dao.selectOne(id);
			if(pw.equals(tmp.getPassword())) {
				dao.selectOne(id);
				return true;
			}
		}
		return false;
	}
	
	public List<Message> list() {
		if(dao.selectAll().size()>0) {
			return dao.selectAll();
		}
		return null;
	}
	
	public List<Message> getMessageList(int pageNumber) {
		//현재 페이지에 표시될 메시지 목록 가져오기
		//화면에 표시될 네비게이션의 정보를 계산 및 생성한다
		
		//1. 현재 페이지에 표시될 메시지 목록 가져오기
		//		firstRow endRow
		/* 1페이지 : 1    - 	10
		 * 2페이지 : 11   - 	20
		 * 3페이지 : 21   - 	30 이런식
		 * 
		 */
		int firstRow = 0;
		int endRow = 0;
		
		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		List<Message> messageList = dao.selectList(firstRow, endRow);
		return messageList;
	}
}