package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public int insertMember(Member m);
	public int updateMember(Member m, String userId);
	public int deleteMember(String id, String userId);
	public Member selectMember(String id);
	public List<Member> selectAllMember();
	public Member selectMemberbyName(String name);
}
