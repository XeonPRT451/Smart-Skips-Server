package cdu.xeon.smartskips.dao;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Driver;

public interface IDriverDao extends IBaseDao<Driver>{

	public Driver loadByUsername(String username);
	
	public Pager<Driver> findDriver();
	
	public void updateDriver(Driver driver);
}
