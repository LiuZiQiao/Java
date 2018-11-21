package dao;


import java.util.List;

import bean.Street;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午3:20:48
* 类说明
*/
public interface StreetDao {
	
	Street findById(String id);
	boolean Insert(Street street);
	boolean deleteById(String id);
	boolean modfiy(Street street);
	
	List<Street> findAll();
	
	public List<Street> seachByName(String name);
	
	public List<Street> seachByType(String type);
	
	public List<Street> seachByManName(String ManName);
	
	public List<Street> seachByArea(String area);

}
