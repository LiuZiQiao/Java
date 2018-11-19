package dao.impl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Street;
import dao.StreetDao;
import dbutil.ConnectionManager;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午3:27:11
* 类说明
*/
public class StreetDaoImpl implements StreetDao {

	@Override
	public Street findById(String id) {
		Street street = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
	
		String sql = "SELECT * from street_table where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
//			Statement stmt = conn.createStatement();//创建执行sql 的语句
//			
//			ResultSet rs = stmt.executeQuery(sql);//执行sql语句			
			while(rs.next())
			{
				street = new Street();
				street.setId(rs.getString("id"));
				street.setName(rs.getString("name"));
				street.setLength(rs.getInt("length"));
				street.setType(rs.getString("type"));
				street.setManName(rs.getString("Manname"));
				street.setArea(rs.getString("area"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return street;
	}

	@Override
	public boolean Insert(Street street) {
		
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "INSERT INTO Street_Table (id , name, length, type, area, manname ) VALUES (?,?,?,?,?,?);";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,street.getId());
			pstmt.setString(2, street.getName());
			pstmt.setInt(3, street.getLength());
			pstmt.setString(4, street.getType());
			pstmt.setString(5, street.getArea());
			pstmt.setString(6, street.getManName());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return true;
	}

	@Override
	public boolean deleteById(String id) {
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		Street street = null;
		String sql = "DELETE FROM Street_Table WHERE ID = ? ";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
//			pstmt.setString(1,street.getId());
//			pstmt.setString(2, street.getName());
//			pstmt.setInt(3, street.getLength());
//			pstmt.setString(4, street.getType());
//			pstmt.setString(5, street.getArea());
//			pstmt.setString(6, street.getManName());
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return true;
	}

	@Override
	public int modfiy(Street street) {
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		int count = 0;
		String sql = "UPDATE  Street_Table SET id = ? ,name =? ,"
				+ "length=? , type=? ,area=? , Manname=?" ;		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,street.getId());
			pstmt.setString(2, street.getName());
			pstmt.setInt(3, street.getLength());
			pstmt.setString(4, street.getType());
			pstmt.setString(5, street.getArea());
			pstmt.setString(6, street.getManName());
			
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return count;
	}

	@Override
	public List<Street> findAll() {
		List<Street> list = new ArrayList<Street>();
		Street street = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Street_Table";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				street = new Street();
				street.setId(rs.getString("id"));
				street.setName(rs.getString("name"));
				street.setType(rs.getString("type"));
				street.setLength(rs.getInt("length"));
				street.setManName(rs.getString("Manname"));
				street.setArea(rs.getString("area"));
				list.add(street);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public Street seachByName(String name) {
		Street street = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT * from street_table where NAME LIKE ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name+"%");;
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				street = new Street();
				street.setId(rs.getString("id"));
				street.setName(rs.getString("name"));
				street.setType(rs.getString("type"));
				street.setLength(rs.getInt("length"));
				street.setManName(rs.getString("Manname"));
				street.setArea(rs.getString("area"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return street;
	}

	@Override
	public List<Street> seachByType(String type) {
		List<Street> list = new ArrayList<Street>();
		Street street = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Street_Table  WHERE type = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				street = new Street();
				street.setId(rs.getString("id"));
				street.setName(rs.getString("name"));
				street.setType(rs.getString("type"));
				street.setLength(rs.getInt("length"));
				street.setManName(rs.getString("Manname"));
				street.setArea(rs.getString("area"));
				list.add(street);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Street> seachByManName(String ManName) {
		List<Street> list = new ArrayList<Street>();
		Street street = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Street_Table  WHERE ManName = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ManName);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				street = new Street();
				street.setId(rs.getString("id"));
				street.setName(rs.getString("name"));
				street.setType(rs.getString("type"));
				street.setLength(rs.getInt("length"));
				street.setManName(rs.getString("Manname"));
				street.setArea(rs.getString("area"));
				list.add(street);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Street> seachByArea(String area) {
		List<Street> list = new ArrayList<Street>();
		Street street = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Street_table  where area = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				street = new Street();
				street.setId(rs.getString("id"));
				street.setName(rs.getString("name"));
				street.setType(rs.getString("type"));
				street.setLength(rs.getInt("length"));
				street.setManName(rs.getString("manname"));
				street.setArea(rs.getString("area"));
				list.add(street);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

}
