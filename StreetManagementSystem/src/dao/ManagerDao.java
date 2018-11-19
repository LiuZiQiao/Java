package dao;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午3:33:13
* 类说明
*/
import bean.Manager;
public interface ManagerDao {
	Manager login(String name,String passwd);
}
