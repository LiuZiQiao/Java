package service;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月12日 下午3:58:27
* 类说明
*/


import java.util.List;

import bean.Street;

public interface StreetService {
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
