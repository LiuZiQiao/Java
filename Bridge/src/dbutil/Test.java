package dbutil;

import java.sql.Connection;
import java.util.List;

import bean.Manager;
import bean.Bridge;
import dao.ManagerDao;
import dao.BridgeDao;
import dao.impl.ManagerDaoImpl;
import dao.impl.BridgeDaoImpl;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月11日 下午11:41:14
* 类说明
*/
public class Test {

	public static void main(String[] args) {
		ManagerDaoImpl man = new ManagerDaoImpl();
		String name = "root";
		String passwd = "123456";
		
		ManagerDao managerDao = new ManagerDaoImpl();
		Manager manager = new Manager();
		manager = managerDao.login(name);
		
		System.out.println("username: "+manager.getName()+" "+"password: "+manager.getPasswd());
		

		
		//创建查询对象
//		StreetDao streetDao = new StreetDaoImpl();

		
	}

}
