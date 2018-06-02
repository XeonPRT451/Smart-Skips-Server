package cdu.xeon.smartskips.dao;

import org.springframework.stereotype.Repository;

import cdu.xeon.basic.dao.BaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Skip;


@Repository("skipDao")
public class SkipDao extends BaseDao<Skip> implements ISkipDao{

	private String getSkipSelect() {
		return "select new Skip(s.id,s.name,s.location,s.full,s.status,s.type,s.capacity,s.currentCapacity,s.longitude,s.latitude,s.count)";
	}

	@Override
	public Pager<Skip> find(Integer did, String name,
			Integer status, Integer type, Integer full) {
		String hql = getSkipSelect()+" from Skip s where 1=1";
		if(status!=null) {
			hql+=" and s.status="+status;
		}
		if(name!=null&&!name.equals("")) {
			hql+=" and s.name like '%"+name+"%'";
		}
 		
 		if(type!=null) {
			hql+=" and s.type="+type;
		}
 		if(full!=null) {
			hql+=" and s.full="+full;
		}
		return this.find(hql);
	}

	
	@Override
	public Pager<Skip> findSkip() {
		return this.find("from Skip");
	}
	@Override
	public void updateSkip(Skip skip) {
		this.getSession().update(skip);
		System.out.println(skip);
	}
}
