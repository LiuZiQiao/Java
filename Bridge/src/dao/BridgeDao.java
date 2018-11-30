package dao;


import java.util.List;

import bean.Bridge;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月7日 下午3:20:48
* 类说明
*/
public interface BridgeDao {
	
	Bridge findById(String id);
	boolean Insert(Bridge bridge);
	boolean deleteById(String id);
	boolean IdIsExist(String id);
	boolean modfiy(Bridge bridge);
	
	List<Bridge> findAll();
	
	public List<Bridge> seachByName(String name);
	
	public List<Bridge> seachByType(String type);
	
	public List<Bridge> seachByManName(String ManName);
	
	public List<Bridge> seachByArea(String area);

}
