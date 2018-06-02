package cdu.xeon.smartskips.service;


import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cdu.xeon.basic.model.Pager;

import cdu.xeon.smartskips.dao.ILandfillDao;
import cdu.xeon.smartskips.dao.IOperatorDao;
import cdu.xeon.smartskips.model.Landfill;
import cdu.xeon.smartskips.model.Operator;
import cdu.xeon.smartskips.model.SmartskipsException;
@Service("operatorService")
public class OperatorService implements IOperatorService{
	
	private IOperatorDao operatorDao;
	private ILandfillDao landfillDao;
	

	
	public IOperatorDao getOperatorDao() {
		return operatorDao;
	}
    @Inject
	public void setOperatorDao(IOperatorDao operatorDao) {
		this.operatorDao = operatorDao;
	}

	public ILandfillDao getLandfillDao() {
		return landfillDao;
	}
    @Inject
	public void setLandfillDao(ILandfillDao landfillDao) {
		this.landfillDao = landfillDao;
	}

	@Override
	public void add(Operator operator, int lid) {
		Landfill l = landfillDao.load(lid);
		Operator td = operatorDao.loadByUsername(operator.getUsername());
		if(td!=null)throw new SmartskipsException("The added operator object already exists and cannot be added");
		operator.setCreateDate(new Date());
		operator.setLname(l.getName());
		operator.setLandfill(l);
		operatorDao.add(operator);
		
	
	}

	@Override
	public void delete(int id) {
		
		operatorDao.delete(id);
	}

	

	@Override
	public void updateStatus(int id) {
		Operator d = operatorDao.load(id);
		if(d==null) throw new SmartskipsException("The operator of the modified state does not exist");
		if(d.getStatus()==0) d.setStatus(1);
		else d.setStatus(0);
		operatorDao.update(d);
	}

	@Override
	public Pager<Operator> findOperator() {
		return operatorDao.findOperator();
	}

	@Override
	public Operator load(int id) {
		return operatorDao.load(id);
	}

	
	
	@Override
	public void update(Operator operator, int lid) {
		Landfill l = landfillDao.load(lid);
		if(l==null) {
			operator.setLname(null);
			operator.setLandfill(null);
		}
		operator.setLname(l.getName());
		operator.setLandfill(l);
		operatorDao.update(operator);
	}
	
	
public Pager<Operator> findOndutyOperator(Integer lid){
	return operatorDao.findOndutyOperator(lid);
		
	}

@Override
public List<Operator> listOperatorByLandfill(int lid) {
	
	return operatorDao.listOperatorByLandfill(lid);
}
	}

