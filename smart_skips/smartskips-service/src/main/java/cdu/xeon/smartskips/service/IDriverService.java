package cdu.xeon.smartskips.service;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Driver;

public interface IDriverService {

	public void add(Driver driver);
	
	public void delete(int id);
	
	public void updateStatus(int id);
	
	public Pager<Driver> findDriver();
	
	public Driver load(int id);
	
	public Driver login(String username, String password);
	
	public void update(Driver driver);
	
	public void updatePwd(int did, String oldPwd, String newPwd);
	
	public void updatePickupSkip(int did, int sid);
	
	public void updateEmptySkip(int did, int lid);
	
	
}
