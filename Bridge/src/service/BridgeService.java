package service;
/**
* @author 作者  小小刘
* @version 创建时间：2018年11月12日 下午3:58:27
* 类说明
*/


import java.util.List;

import bean.Bridge;

public interface BridgeService {
	Bridge findById(String id);
	boolean Insert(Bridge street);
	boolean deleteById(String id);
	
	boolean IdIsExist(String id);
	boolean modfiy(Bridge street);
	
	List<Bridge> findAll();
	
	public List<Bridge> seachByName(String name);
	
	public List<Bridge> seachByType(String type);
	
	public List<Bridge> seachByManName(String ManName);
	
	public List<Bridge> seachByArea(String area);
}
