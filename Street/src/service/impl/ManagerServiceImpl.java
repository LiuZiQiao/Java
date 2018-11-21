package service.impl;

import bean.Manager;
import dao.impl.ManagerDaoImpl;
import service.ManagerService;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月21日 下午1:29:56
* 类说明
*/
public class ManagerServiceImpl implements ManagerService {

	@Override
	public boolean login(Manager admin) {
		ManagerDaoImpl managerDaoImpl  = new ManagerDaoImpl();
		Manager manager  = managerDaoImpl.login(admin.getName());
		
		//将用户传入的用户名的密码与数据库中的密码比较
		if (admin.equals(manager)) {
			System.out.println("user:"+manager.getName()+"passwd:"+manager.getPasswd());
			return true;
		}
		return false;
	}
	
}
