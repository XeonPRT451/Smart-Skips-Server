package cdu.xeon.smartskips.service;

import java.util.List;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Operator;

public interface IOperatorService {
	
public void add(Operator operator, int lid);
	
	public void delete(int id);
	
	public void updateStatus(int id);
	
	public Pager<Operator> findOperator();
	
	public Operator load(int id);
	

	
	public void update(Operator operator, int lid);
	

	
	public Pager<Operator> findOndutyOperator(Integer lid);
	
	public List<Operator> listOperatorByLandfill(int lid);
	

}
