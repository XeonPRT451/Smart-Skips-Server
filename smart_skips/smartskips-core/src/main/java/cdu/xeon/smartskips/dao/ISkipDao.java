package cdu.xeon.smartskips.dao;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;

import cdu.xeon.smartskips.model.Skip;

public interface ISkipDao extends IBaseDao<Skip>{

	public Pager<Skip> find(Integer did, String name,Integer status, Integer type, Integer full);
	
	public Pager<Skip> findSkip();
	
	public void updateSkip(Skip skip);
	
}
