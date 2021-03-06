package service;

import java.util.List;

import dao.MemberDao;
import model.Member;

public class MemberService {
	//Dao 객체를 멤버로 가지면서 사용
	MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	//로직이 들가면됩니다. ex 로그인:성공 or 실패
	public boolean login(String id, String pw) {
		//1. 데이터 베이스에서 입력받은 아이디와 동일한 회원 정보를 조회
		Member member = memberDao.selectOne(id);
		if(member != null) {
			//해당 아이디의 회원정보는 존재 
			if(member.getPw().equals(pw)) {
				//로그인 성공
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean join(Member member) {
		//전달받은 파라미터를 데이터 베이스에 insert 성공하면 true, 실패하면 false
		int insertResult = memberDao.insertMember(member);
		boolean result = false;
		if(insertResult == 1) {
			result =true;
		}
		
		return result;
	}
	public boolean modify(Member member) {
		int updateResult = memberDao.updateMember(member);
		boolean result = false;
		if(updateResult >0) {
			result = true;
		}
		return result;
	}
	//수정할 때 회원 한명의 정보를 가져와야 함,
	public Member getMember(String id) {
		return memberDao.selectOne(id);
	}
	public Member getMemberByEmail(String email) {
		return memberDao.selectOneByEmail(email);
	}
	
	public List<Member> getAllMembers(){
		return memberDao.selectAll();
	}
	public boolean delete(String id) {
		int deleteResult = memberDao.deleteMember(id);
		if(deleteResult > 0) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
}
