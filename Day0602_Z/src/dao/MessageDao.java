package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Message;


public class MessageDao {
	Connection connection;
	
	public void insert(Message m) {
		PreparedStatement pstmt = null;
		String sql;
		boolean nameIsNull;
		if(m.getName().equals("")) {
			sql = "insert into message (id, password, message) values (message_seq.nextval, ?, ?)";
			nameIsNull=true;
		} else {
			sql = "insert into message values (message_seq.nextval, ?, ?, ?)";
			nameIsNull=false;
		}
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			if(nameIsNull) {
				pstmt.setString(1, m.getPassword());
				pstmt.setString(2, m.getMessage());
				pstmt.executeUpdate();
			} else {
				pstmt.setString(1, m.getPassword());
				pstmt.setString(2, m.getName());
				pstmt.setString(3, m.getMessage());
				pstmt.executeUpdate();
			}
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

	public List<Message> selectAll() {
		List<Message> mList = null;
		String sql = "select * from message";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			mList = new ArrayList<Message>();
			while(rs.next()) {
				Message tmp = new Message();
				System.out.println(rs.getInt("id"));
				tmp.setId(rs.getInt("id"));
				tmp.setName(rs.getString("name"));
				tmp.setPassword(rs.getString("password"));
				tmp.setMessage(rs.getString("message"));
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
