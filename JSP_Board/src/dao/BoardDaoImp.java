package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Board;

public class BoardDaoImp implements BoardDao {
	//interFace BoardDao를 구현하는 BoardDaoImp 클래스 구현
	private static BoardDao instance;
	private BoardDaoImp() {}
	public static BoardDao getInstance() {
		if(instance==null) {
			instance = new BoardDaoImp();
		}
		return instance;
	}
	@Override
	public int insertBoard(Board board) {
		String sql="insert into board (num, title, name, pass, email, content) values(board_seq.nextval,?,?,?,?,?)";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public int updateBoard(Board board) {
		String sql="update board set"
				+ " 		title = ?,"
				+ "         name = ?,"
				+ "			pass = ?,"
				+ "			email = ?,"
				+ "			content = ?"
				+ " 		where num=?";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getPass());
			pstmt.setString(4, board.getEmail());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public int deleteBoard(String num) {
		String sql="delete from board where num=?";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, num);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public Board selectOne(String num) {
		String sql="select * from board where num=?";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board board=null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setPass(rs.getString("pass"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setWriteDate(rs.getDate("writeDate"));
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
		return board;
	}
	@Override
	public List<Board> selectAll() {
		String sql="select * from board order by num desc";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> list=null;
		try {
			list = new ArrayList<Board>();
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setPass(rs.getString("pass"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setWriteDate(rs.getDate("writeDate"));
				list.add(board);
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
	public int upReadCount(String num) {
		String sql = "update board set" 
				+ "	   readCount = readCount+1"
				+ "    where num = ?";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, num);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) connection.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
