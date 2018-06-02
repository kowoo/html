package service;

import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;

public class MemberService {
	//Dao 객체를 멤버로 가지면서 사용함
	MemberDao dao = new MemberDao();
	//로직으로 들어가면 됨
	public boolean login(String id, String pw) {
		//1. 데이터베이스에서 입력받은 아이디와 동일한 회원 정보를 조회
		//2. 회원정보가 존재하면 비밀번호 검사
		//3-1. 비밀번호가 같으면 로그인 성공
		//3-2. 틀리면 로그인 실패
		//4. 로그인 결과에 따라 논리값 반환
		if(dao.selectOne(id).getId()!=null) {
			if(pw.equals(dao.selectOne(id).getPw())) {
				return true;
			}
		}
		return false;
	}
	public boolean join(Member m) {
		if(dao.selectOne(m.getId())==null) {
			dao.insert(m);
			return true;
		} else {
			return false;
		}
	}
	public List<Member> memberAll() {
		List<Member> mList = new ArrayList<Member>();
		mList = dao.selectAll();
		return mList;
	}

	public Member call(String id) {
		return dao.selectOne(id);
	}
	
	public void modify(Member m) {
		dao.update(m);
	}
	public boolean drop(String id, String pw) {
		if(dao.selectOne(id)!=null) {
			if(dao.selectOne(id).getPw()!=null) {
				if(pw.equals(dao.selectOne(id).getPw())) {
					dao.delete(id);
					return true;
				}
			}
		}
		return false;
	}
}
