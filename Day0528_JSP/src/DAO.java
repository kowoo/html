import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class DAO {
	Connection conn;
	int num;
	
	public void insert(Student student) {
		String sql = "insert into student values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(0, num);
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getGrade());
			pstmt.setInt(4, student.getKor());
			pstmt.setInt(5, student.getEng());
			pstmt.setInt(6, student.getMath());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int snum) {
		String sql = "delete from student where snum="+snum;
		PreparedStatement pstmt = null;
		
			try {
				conn = Connect.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) conn.close();
					if (pstmt != null) pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public List<Student> All() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setSnum(rs.getInt("snum"));
				s.setName(rs.getString("name"));
				s.setGrade(rs.getInt("grade"));
				s.setKor(rs.getInt("kor"));
				s.setEng(rs.getInt("eng"));
				s.setMath(rs.getInt("math"));
				list.add(s);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}

