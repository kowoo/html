package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberDao {
	Connection connection;
	
	public void insert(Member m) {
		PreparedStatement pstmt = null;
		String sql = "insert into member values (?, ?, ?, ?, sysdate)";
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(String id) {
		String sql = "delete from member where id = '"+id+"'";
		PreparedStatement pstmt = null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update(Member m) {
		PreparedStatement pstmt = null;
		String sql = "update member set pw = ?, "
				+ "						name = ?,"
				+ "						email = ?"
				+ "					where id = '"+m.getId()+"'";
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, m.getPw());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Member selectOne(String id) {
		Member member = null;
		String sql = "select * from member where id ='"+id+"'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setRegDate(rs.getDate("regdate"));
				System.out.println(member);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	 
		return member;
	}
	
	public List<Member> selectAll() {
		List<Member> mList = null;
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			mList = new ArrayList<Member>();
			while(rs.next()) {
				Member tmp = new Member();
				tmp.setId(rs.getString("id"));
				tmp.setPw(rs.getString("pw"));
				tmp.setName(rs.getString("name"));
				tmp.setEmail(rs.getString("email"));
				tmp.setRegDate(rs.getDate("regdate"));
				mList.add(tmp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return mList;
	}
}
