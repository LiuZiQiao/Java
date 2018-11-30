package dbutil;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午2:53:04
* 类说明
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String dirver ="com.mysql.jdbc.Driver";
	private static final String url ="jdbc:mysql://localhost:3306/Bridge";
	private static final String user ="root";
	private static final String passwd ="123456";
	private ConnectionManager() {
		
	}
	
	static Connection conn = null;
	public static Connection getConnection()
	{
		try {
			Class.forName(dirver);
			
			conn = DriverManager.getConnection(url+"?useUnicode=true&characterEncoding=UTF8", user, passwd);
			if (conn != null) {
				System.out.println("connection successful");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection() {
		if (conn!=null) {
			try {
				if(!conn.isClosed())
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ConnectionManager.getConnection();
	}

}
