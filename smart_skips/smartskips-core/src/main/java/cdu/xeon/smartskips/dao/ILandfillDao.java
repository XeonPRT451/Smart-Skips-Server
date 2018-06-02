package cdu.xeon.smartskips.dao;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Landfill;


public interface ILandfillDao extends IBaseDao<Landfill>{

	
	public Pager<Landfill> findLandfill();
	
}
