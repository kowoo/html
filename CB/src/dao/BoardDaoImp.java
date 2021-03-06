package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Board;

public class BoardDaoImp implements BoardDao {
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
		String sql="insert into board2 (num, writerId, title, name, content) values(board_seq2.nextval,?,?,?,?)";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, board.getWriterId());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getName());
			pstmt.setString(4, board.getContent());
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
	public int updateBoard(Board board, String userId) {
		String sql="update board2 set"
				+ " 		title = ?,"
				+ "			content = ?"
				+ " 		where num= ?";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			if(!board.getWriterId().equals(userId)) {
				return -1;
			}
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNum());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
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
	public int deleteBoard(String num, String userId) {
		String sql="delete from board2 where num=?";
		Connection connection=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			if(!selectBoard(num).getWriterId().equals(userId)) {
				return -1;
			}
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
	public Board selectBoard(String num) {
		String sql="select * from board2 where num=?";
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
				board.setComments(rs.getInt("comments"));
				board.setWriterId(rs.getString("writerId"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				Date date = rs.getDate("writeDate");
				SimpleDateFormat f = new SimpleDateFormat("yyyy/mm/dd hh24:mm:ss");
				board.setWriteDate(date);
				board.setWriteDateString(f.format(date));
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
	public List<Board> searchBoards(String opt, String keyword) {
		String sql="select * from board2 where "+opt
				+ " like ? order by num desc";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> list=null;
		try {
			list = new ArrayList<Board>();
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setComments(rs.getInt("comments"));
				board.setName(rs.getString("name"));
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
		String sql = "update board2 set" 
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
	@Override
	public int upComment(String num) {
		String sql = "update board2 set" 
				+ "	   comments = comments+1"
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
	@Override
	public List<Board> selectAllBoard(int firstRow, int endRow) {
		String sql = "select * "
					+ "from (select rownum as rnum, b.num, b.title, b.writeDate, b.readCount, b.content, b.name, b.comments "
					+ "from (select num, title, writeDate, readCount, content, name, comments "
					+ "from board2 order by num desc)b) "
					+ "where rnum between ? and ?";
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Board> list=null;
		try {
			list = new ArrayList<Board>();
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setComments(rs.getInt("comments"));
				board.setWriteDate(rs.getDate("writeDate"));
				Date date = rs.getDate("writeDate");
				board.setWriteDate(date);
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
	public List<Board> selectAllBoard() {
		String sql = "select * from board2";
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
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setComments(rs.getInt("comments"));
				board.setWriteDate(rs.getDate("writeDate"));
				Date date = rs.getDate("writeDate");
				board.setWriteDate(date);
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
	public int boardCount() {
		String sql = "select count(*) from board2";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result  = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public int downComment(String num) {
		String sql = "update board2 set" 
				+ "	   comments = comments-1"
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