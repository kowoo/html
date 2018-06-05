package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Members;

public class MemberDao {
	private static MemberDao instance;
	public MemberDao() {}
	public static MemberDao getInstance() {
		// 만들어진 객체가 없다면, 객체를 만들어서 반환
		if (instance == null) {
			instance = new MemberDao();
		}
		// 있다면, 객체를 만들지 않고 그냥 반환
		return instance;
	}

	public void insertMember(Members m) {
		String sql = "insert into values (members_seq.nextval,?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getNick());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void updateMember(Members m) {
		String sql = "update members"
				+ 			"	 set  pw=?,"
				+			"       name=?,"
				+			"       nick=?"
				+			"   where id='"+"?"+"'";
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getPw());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getNick());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	public Members selectMember(String id) {
		String sql = "select * from members where id='"+"?"+"'";
		Members tmp=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tmp = new Members();
				tmp.setMemberNumber(rs.getInt("memberNumber"));
				tmp.setId(rs.getString("id"));
				tmp.setPw(rs.getString("pw"));
				tmp.setName(rs.getString("name"));
				tmp.setNick(rs.getString("nick"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tmp;
	}
	public List<Members> selectAll() {
		String sql = "select * from members";
		List<Members> list=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			list = new ArrayList<Members>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Members tmp = new Members();
				tmp.setMemberNumber(rs.getInt("memberNumber"));
				tmp.setId(rs.getString("id"));
				tmp.setPw(rs.getString("pw"));
				tmp.setName(rs.getString("name"));
				tmp.setNick(rs.getString("nick"));
				list.add(tmp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	
	public void delete(String id) {
		String sql = "delete from members where id='"+"?"+"'";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
