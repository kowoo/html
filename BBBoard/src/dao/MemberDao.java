package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public int insertMember(Member m);
	public int updateMember(Member m);
	public int deleteMember(String id);
	public Member selectMember(String id);
	public List<Member> selectAllMember();
}
