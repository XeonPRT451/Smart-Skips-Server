package cdu.xeon.smartskips.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.dao.ILandfillDao;

import cdu.xeon.smartskips.model.Landfill;
import cdu.xeon.smartskips.model.Operator;
import cdu.xeon.smartskips.model.SmartskipsException;
@Service("landfillService")
public class LandfillService implements ILandfillService{
	
	private IOperatorService operatorService;
	private ILandfillDao landfillDao;
	

	
	public IOperatorService getOperatorService() {
		return operatorService;
	}
    @Inject
	public void setOperatorDao(IOperatorService operatorService) {
		this.operatorService = operatorService;
	}

	public ILandfillDao getLandfillDao() {
		return landfillDao;
	}
    @Inject
	public void setLandfillDao(ILandfillDao landfillDao) {
		this.landfillDao = landfillDao;
	}
    
	@Override
	public void add(Landfill landfill) {
		
		Landfill tl = landfillDao.load(landfill.getId());
		if(tl!=null)throw new SmartskipsException("The added landfill object already exists and cannot be added");
		landfillDao.add(landfill);
		
	
	}

	@Override
	public void delete(int id) {
		List<Operator> to = operatorService.listOperatorByLandfill(id);
		if(to.size()>0) {
			throw new SmartskipsException("This column also has corresponding article information, cannot delete");
		}
		landfillDao.delete(id);
	}

	

	@Override
	public void updateStatus(int id) {
		Landfill l = landfillDao.load(id);
		if(l==null) throw new SmartskipsException("The landfill of the modified status does not exist");
		if(l.getStatus()==0) l.setStatus(1);
		else l.setStatus(0);
		landfillDao.update(l);
	}


	@Override
	public Pager<Landfill> findLandfill() {
		return landfillDao.findLandfill();
	}

	@Override
	public Landfill load(int id) {
		return landfillDao.load(id);
	}

	
	
	@Override
	public void update(Landfill landfill, int did) {

		landfillDao.update(landfill);
	}
	
	
	public void clearOperator(int id) {
		List<Operator> os = operatorService.listOperatorByLandfill(id);
		for(Operator o:os) {
			operatorService.delete(o.getId());
		}
	}

}
