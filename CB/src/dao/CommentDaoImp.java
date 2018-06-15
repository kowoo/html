package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;

public class CommentDaoImp implements CommentDao {
	private static CommentDao instance;
	private CommentDaoImp() {}
	public static CommentDao getInstance() {
		if(instance==null) {
			instance = new CommentDaoImp();
		}
		return instance;
	}
	@Override
	public int insertComment(Comment c) {
		String sql = "insert into comment2 values (?,comment_seq2.nextval,?,?,?,sysdate)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getNum());
			pstmt.setString(2, c.getWriterId());
			pstmt.setString(3, c.getName());
			pstmt.setString(4, c.getText());
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
	public int deleteComment(String id, String count) {
		String sql = "delete from comment2 where count='"+count+"'";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			if(!selectComment(count).getWriterId().equals(id)) {
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
	public Comment selectComment(String count) {
		String sql="select * from comment2 where count='"+count+"'";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Comment c=null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				c = new Comment();
				c.setNum(rs.getInt("num"));
				c.setCount(rs.getInt("count"));
				c.setName(rs.getString("name"));
				c.setWriterId(rs.getString("writerId"));
				c.setText(rs.getString("text"));
				c.setWriteDate(rs.getDate("writeDate"));
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
		return c;
	}
	@Override
	public List<Comment> selectAllComment() {
		String sql="select * from comment2";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Comment> list=null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Comment>();
			while(rs.next()) {
				Comment c = new Comment();
				c.setNum(rs.getInt("num"));
				c.setCount(rs.getInt("count"));
				c.setName(rs.getString("name"));
				c.setWriterId(rs.getString("writerId"));
				c.setText(rs.getString("text"));
				c.setWriteDate(rs.getDate("writeDate"));
				list.add(c);
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
	public List<Comment> selectAllCommentbyBoard(String num) {
		String sql="select * from comment2 where num='"+num+"'";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Comment> list=null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Comment>();
			while(rs.next()) {
				Comment c = new Comment();
				c.setNum(rs.getInt("num"));
				c.setCount(rs.getInt("count"));
				c.setName(rs.getString("name"));
				c.setWriterId(rs.getString("writerId"));
				c.setText(rs.getString("text"));
				c.setWriteDate(rs.getDate("writeDate"));
				list.add(c);
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
}
