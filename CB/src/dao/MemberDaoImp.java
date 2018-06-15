package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberDaoImp implements MemberDao {
	private static MemberDao instance;
	private MemberDaoImp() {}
	public static MemberDao getInstance() {
		if(instance==null) {
			instance = new MemberDaoImp();
		}
		return instance;
	}
	@Override
	public int insertMember(Member m) {
		String sql = "insert into member2 values (?,?,?,?,sysdate,0,0)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public int updateMember(Member m, String userId) {
		String sql = "update member2 "
				+ "				 set pw    = ?,"
				+ "					 name  = ?,"
				+ "                  email = ?"
				+ "  		   where id    = ?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			if(!m.getId().equals(userId)) {
				return -1;
			}
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPw());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getId());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public int deleteMember(String id, String userId) {
		String sql = "delete from member2 where id='"+id+"'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			if(!id.equals(userId)) {
				return -1;
			}
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public Member selectMember(String id) {
		String sql="select * from member2 where id='"+id+"'";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				m = new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setRegDate(rs.getDate("regDate"));
				m.setBoardW(rs.getInt("boardw"));
				m.setCommentW(rs.getInt("commentw"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	@Override
	public List<Member> selectAllMember() {
		String sql="select * from member2";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			list = new ArrayList<Member>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setRegDate(rs.getDate("regDate"));
				m.setBoardW(rs.getInt("boardw"));
				m.setCommentW(rs.getInt("commentw"));
				list.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	@Override
	public Member selectMemberbyName(String name) {
		String sql="select * from member2 where name='"+name+"'";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				m = new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setRegDate(rs.getDate("regDate"));
				m.setBoardW(rs.getInt("boardw"));
				m.setCommentW(rs.getInt("commentw"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
}
