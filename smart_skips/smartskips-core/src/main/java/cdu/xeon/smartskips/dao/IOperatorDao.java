package cdu.xeon.smartskips.dao;

import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;

import cdu.xeon.smartskips.model.Operator;


public interface IOperatorDao extends IBaseDao<Operator>{

	public Pager<Operator> findOndutyOperator(Integer lid);
	public Pager<Operator> findOperator();
	
	public Operator loadByUsername(String username);
	public List<Operator> listOperatorByLandfill(int lid);
	
	
}
