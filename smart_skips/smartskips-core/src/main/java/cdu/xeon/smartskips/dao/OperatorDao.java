package cdu.xeon.smartskips.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import cdu.xeon.basic.dao.BaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Operator;

@Repository("operatorDao")
public class OperatorDao extends BaseDao<Operator> implements IOperatorDao{

	private String getOperatorSelect() {
		return "select new Operator(o.id,o.username,o.nickname,o.email,o.phone,o.status,o.onduty,o.createDate,o.lname)";
	}
	
	@Override
	public Pager<Operator> findOndutyOperator(Integer lid) {
		String hql = getOperatorSelect()+" from Operator o where o.status=1 and o.onduty=1";
		if(lid==null||lid==0) {
			return this.find(hql);
		} else {
			hql +=" and o.landfill.id=?";
			return this.find(hql, lid);
		}
	}
	
	@Override
	public Pager<Operator> findOperator() {
		return this.find("from Operator");
	}
	
	@Override
	public Operator loadByUsername(String username) {
		String hql = "from Operator where username=?";
		return (Operator)this.queryObject(hql, username);
	}
	
	@Override
	public List<Operator> listOperatorByLandfill(int lid) {
		String hql = "select o from Operator o where o.landfill.id=?";
		return this.list(hql,lid);
	}
	
}
