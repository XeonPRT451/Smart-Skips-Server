package cdu.xeon.smartskips.dao;

import org.springframework.stereotype.Repository;

import cdu.xeon.basic.dao.BaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Driver;

@Repository("driverDao")
public class DriverDao extends BaseDao<Driver> implements IDriverDao{
	
	@Override
	public Driver loadByUsername(String username) {
		String hql = "from Driver where username=?";
		return (Driver)this.queryObject(hql, username);
	}
	
	@Override
	public Pager<Driver> findDriver() {
		return this.find("from Driver");
	}
	
	@Override
	public void updateDriver(Driver driver) {
		this.getSession().update(driver);
		System.out.println(driver);
	}

}
