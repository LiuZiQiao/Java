package dbutil;

import java.sql.Connection;
import java.util.List;

import bean.Manager;
import bean.Street;
import dao.ManagerDao;
import dao.StreetDao;
import dao.impl.ManagerDaoImpl;
import dao.impl.StreetDaoImpl;

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
		manager = managerDao.login(name, passwd);
		
		System.out.println("username: "+manager.getName()+" "+"password: "+manager.getPasswd());
		
//		if (manager.equals(managerDao)) {
//			System.out.println("longin success");
//		}
//		else
//		{
//			System.out.println("login fail");
//		}
		
		//创建查询对象
//		StreetDao streetDao = new StreetDaoImpl();

		//增加
//		Street street = new Street("1","caotanjiedao","xue",100,"liu","weiyangqu");
//		System.out.println(streetDao.Insert(street));	//ok
		//查找
//		System.out.println(streetDao.findById("2"));  //ok
		//查找全部
//		List<Street> list = streetDao.findAll();
//		for (int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}	//ok
		
		//通过街道名称查找
//		Street street = new Street();
//		street = streetDao.seachByName("caotanjiedao");
//		System.out.println(street);  //ok
		
		//通过街道类型查找
//		List<Street> list = streetDao.seachByType("xue");
//		for (int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}	//ok
		
		//通过街道管理人员来查
//		List<Street> list = streetDao.seachByManName("zhang");
//		for (int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}	//ok
		
//		List<Street> list = streetDao.seachByArea("weiyangqu");
//		for (int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}	//ok
		
		//删除
//		System.out.println(streetDao.deleteById("1"));    //ok

//		Street street = new Street("3","xuefujie","xue",500,"zhang","weiyangqu");
//		System.out.println(streetDao.modfiy(street));     //ok
		
	}

}
