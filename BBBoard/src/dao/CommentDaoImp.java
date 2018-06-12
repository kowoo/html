package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Comment;

public class CommentDaoImp implements CommentDao {
	@Override
	public int insertComment(Comment c) {
		//외래키 개념을 공부해서 게시글과 연결
		//게시글 삭제 시 삭제 되도록
		//게시글 클릭 시 로드 되도록 해보자
		String sql = "insert into comment2 values (?,?,?,?,sysdate)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getTitle());
			pstmt.setInt(2, c.getNum());
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
	public int deleteComment(String num) {
		return 0;
	}
	@Override
	public Comment selectComment(String num) {
		return null;
	}
	@Override
	public List<Comment> selectAllComment() {
		return null;
	}
	
}
