package service;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月12日 下午3:58:27
* 类说明
*/


import java.util.List;

import bean.Street;

public interface StreetService {
	Street findById(int id);
	boolean Insert(Street street);
	boolean DeleteById(int id);
	int modfiy(Street street);
	List<Street> findAll();
}
