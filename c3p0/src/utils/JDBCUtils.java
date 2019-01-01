package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	 public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	 }
	 
	 public static void test() throws Exception {
	
		 ComboPooledDataSource pool = new ComboPooledDataSource();
		 Connection conn = pool.getConnection();
		 String  sql = "select *from user";
		 ResultSet rs = conn.createStatement().executeQuery(sql);
		 
		 while (rs.next()) {
			System.out.println(rs.getString(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
		 }
		 rs.close();
	 }
	 
	

}
