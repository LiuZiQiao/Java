package service.impl;

import java.util.List;

import bean.Bridge;
import dao.BridgeDao;
import dao.impl.BridgeDaoImpl;
import service.BridgeService;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月15日 下午3:42:23
* 类说明
*/
public class BridgeServiceImpl implements BridgeService {
	
	BridgeDao bridge = new BridgeDaoImpl();
	
	@Override
	public Bridge findById(String id) {
		
		return bridge.findById(id) ;
	}

	@Override
	public boolean Insert(Bridge street) {
		
		return bridge.Insert(street);
	}

	@Override
	public boolean deleteById(String id) {
		
		return bridge.deleteById(id);
	}

	@Override
	public boolean modfiy(Bridge street) {
		
		return bridge.modfiy(street);
	}

	@Override
	public List<Bridge> findAll() {
		
		return bridge.findAll();
	}

	@Override
	public List<Bridge> seachByName(String name) {
		
		return bridge.seachByName(name);
	}

	@Override
	public List<Bridge> seachByType(String type) {
		
		return bridge.seachByType(type);
	}

	@Override
	public List<Bridge> seachByManName(String ManName) {
		
		return bridge.seachByManName(ManName);
	}

	@Override
	public List<Bridge> seachByArea(String area) {
		
		return bridge.seachByArea(area);
	}


}
