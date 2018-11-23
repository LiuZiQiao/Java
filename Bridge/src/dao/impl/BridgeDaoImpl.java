package dao.impl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Bridge;
import dao.BridgeDao;
import dbutil.ConnectionManager;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午3:27:11
* 类说明
*/
public class BridgeDaoImpl implements BridgeDao {

	@Override
	public Bridge findById(String id) {
		Bridge bridge = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
	
		String sql = "SELECT * from Bridge_table where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
//			Statement stmt = conn.createStatement();//创建执行sql 的语句
//			
//			ResultSet rs = stmt.executeQuery(sql);//执行sql语句			
			while(rs.next())
			{
				bridge = new Bridge();
				bridge.setId(rs.getString("id"));
				bridge.setName(rs.getString("name"));
				bridge.setLength(rs.getInt("length"));
				bridge.setType(rs.getString("type"));
				bridge.setManName(rs.getString("Manname"));
				bridge.setArea(rs.getString("area"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return bridge;
	}

	@Override
	public boolean Insert(Bridge bridge) {
		
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "INSERT INTO Bridge_Table (id , name, length, type, area, manname ) VALUES (?,?,?,?,?,?);";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,bridge.getId());
			pstmt.setString(2, bridge.getName());
			pstmt.setInt(3, bridge.getLength());
			pstmt.setString(4, bridge.getType());
			pstmt.setString(5, bridge.getArea());
			pstmt.setString(6, bridge.getManName());
			
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
		String sql = "DELETE FROM Bridge_Table WHERE ID = ? ";
		
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
	public boolean modfiy(Bridge bridge) {
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "UPDATE  Bridge_Table SET id = ? ,name =? ,"
				+ "length=? , type=? ,area=? , Manname=?" ;		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,bridge.getId());
			pstmt.setString(2, bridge.getName());
			pstmt.setInt(3, bridge.getLength());
			pstmt.setString(4, bridge.getType());
			pstmt.setString(5, bridge.getArea());
			pstmt.setString(6, bridge.getManName());
			
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
	public List<Bridge> findAll() {
		List<Bridge> list = new ArrayList<Bridge>();
		Bridge bridge = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Bridge_Table";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				bridge = new Bridge();
				bridge.setId(rs.getString("id"));
				bridge.setName(rs.getString("name"));
				bridge.setType(rs.getString("type"));
				bridge.setLength(rs.getInt("length"));
				bridge.setManName(rs.getString("Manname"));
				bridge.setArea(rs.getString("area"));
				list.add(bridge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Bridge> seachByName(String name) {
		Bridge bridge = null;
		List<Bridge> list = new ArrayList<Bridge>();
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT * from Bridge_table where NAME LIKE ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name+"%");;
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				bridge = new Bridge();
				bridge.setId(rs.getString("id"));
				bridge.setName(rs.getString("name"));
				bridge.setType(rs.getString("type"));
				bridge.setLength(rs.getInt("length"));
				bridge.setManName(rs.getString("Manname"));
				bridge.setArea(rs.getString("area"));
				list.add(bridge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Bridge> seachByType(String type) {
		List<Bridge> list = new ArrayList<Bridge>();
		Bridge bridge = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Bridge_Table  WHERE type = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				bridge = new Bridge();
				bridge.setId(rs.getString("id"));
				bridge.setName(rs.getString("name"));
				bridge.setType(rs.getString("type"));
				bridge.setLength(rs.getInt("length"));
				bridge.setManName(rs.getString("Manname"));
				bridge.setArea(rs.getString("area"));
				list.add(bridge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Bridge> seachByManName(String ManName) {
		List<Bridge> list = new ArrayList<Bridge>();
		Bridge bridge = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Bridge_Table  WHERE ManName = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ManName);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				bridge = new Bridge();
				bridge.setId(rs.getString("id"));
				bridge.setName(rs.getString("name"));
				bridge.setType(rs.getString("type"));
				bridge.setLength(rs.getInt("length"));
				bridge.setManName(rs.getString("Manname"));
				bridge.setArea(rs.getString("area"));
				list.add(bridge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

	@Override
	public List<Bridge> seachByArea(String area) {
		List<Bridge> list = new ArrayList<Bridge>();
		Bridge bridge = null;
		Connection conn = ConnectionManager.getConnection();
		if (conn != null) {
			System.out.println("conn is true");
		}
		String sql = "SELECT *from Bridge_table  where area = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				bridge = new Bridge();
				bridge.setId(rs.getString("id"));
				bridge.setName(rs.getString("name"));
				bridge.setType(rs.getString("type"));
				bridge.setLength(rs.getInt("length"));
				bridge.setManName(rs.getString("Manname"));
				bridge.setArea(rs.getString("area"));
				list.add(bridge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return list;
	}

}
