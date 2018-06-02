package cdu.xeon.smartskips.dao;

import org.springframework.stereotype.Repository;

import cdu.xeon.basic.dao.BaseDao;
import cdu.xeon.basic.model.Pager;

import cdu.xeon.smartskips.model.Landfill;

@Repository("landfillDao")
public class LandfillDao extends BaseDao<Landfill> implements ILandfillDao{

	@Override
	public Pager<Landfill> findLandfill() {
		return this.find("from Landfill");
	}
}
