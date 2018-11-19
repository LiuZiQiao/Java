package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Manager;
import dao.ManagerDao;
import dbutil.ConnectionManager;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午3:42:17
* 类说明
*/
public class ManagerDaoImpl implements ManagerDao {

	@Override
	public Manager login(String name,String passwd) {
		String sql = "SELECT *FROM MANAGER_TABLE WHERE username = ?";
		Connection conn = ConnectionManager.getConnection();
		Manager manager = new Manager();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				manager.setName(rs.getString("username"));
				manager.setPasswd(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection();
		}
		return manager;
	}
}
