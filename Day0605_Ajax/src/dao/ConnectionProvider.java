package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER="kwh";
	private static final String PASSWORD="1";

	public ConnectionProvider() {}
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
