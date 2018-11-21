package service.impl;

import java.util.List;

import bean.Street;
import dao.StreetDao;
import dao.impl.StreetDaoImpl;
import service.StreetService;

/**
* @author 作者  小小刘
* @version 创建时间：2018年11月15日 下午3:42:23
* 类说明
*/
public class StreetServiceImpl implements StreetService {
	
	StreetDao streets = new StreetDaoImpl();
	
	@Override
	public Street findById(String id) {
		
		return streets.findById(id) ;
	}

	@Override
	public boolean Insert(Street street) {
		
		return streets.Insert(street);
	}

	@Override
	public boolean deleteById(String id) {
		
		return streets.deleteById(id);
	}

	@Override
	public boolean modfiy(Street street) {
		
		return streets.modfiy(street);
	}

	@Override
	public List<Street> findAll() {
		
		return streets.findAll();
	}

	@Override
	public List<Street> seachByName(String name) {
		
		return streets.seachByName(name);
	}

	@Override
	public List<Street> seachByType(String type) {
		
		return streets.seachByType(type);
	}

	@Override
	public List<Street> seachByManName(String ManName) {
		
		return streets.seachByManName(ManName);
	}

	@Override
	public List<Street> seachByArea(String area) {
		
		return streets.seachByArea(area);
	}


}
