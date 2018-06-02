package cdu.xeon.smartskips.service;



import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.dao.IDriverDao;
import cdu.xeon.smartskips.dao.ISkipDao;
import cdu.xeon.smartskips.model.Driver;
import cdu.xeon.smartskips.model.Skip;
import cdu.xeon.smartskips.model.SmartskipsException;
@Service("skipService")
public class SkipService implements ISkipService {

	private IDriverDao driverDao;
	private ISkipDao skipDao;
	

	public IDriverDao getDriverDao() {
		return driverDao;
	}
	@Inject
	public void setDriverDao(IDriverDao driverDao) {
		this.driverDao = driverDao;
	}

	
	public ISkipDao getSkipDao() {
		return skipDao;
	}
	
	@Inject
	public void setSkipDao(ISkipDao skipDao) {
		this.skipDao = skipDao;
	}
	
	@Override
	public void add(Skip skip) {
		
		Skip ts = skipDao.load(skip.getId());
		if(ts!=null)throw new SmartskipsException("The added skip object already exists and cannot be added");
		skipDao.add(skip);
		
	
	}

	@Override
	public void delete(int id) {
		
		skipDao.delete(id);
	}

	

	@Override
	public void updateStatus(int id) {
		Skip s = skipDao.load(id);
		if(s==null) throw new SmartskipsException("The skip of the modified status does not exist");
		if(s.getStatus()==0) s.setStatus(1);
		else s.setStatus(0);
		skipDao.update(s);
	}

	@Override
	public void updateFull(int id) {
		Skip s = skipDao.load(id);
		if(s==null) throw new SmartskipsException("The skip of the modified status does not exist");
		if(s.getFull()==0) s.setFull(1);
		else s.setFull(0);
		skipDao.update(s);
	}
	
	@Override
	public Pager<Skip> findSkip() {
		return skipDao.findSkip();
	}

	@Override
	public Skip load(int id) {
		return skipDao.load(id);
	}

	
	
	@Override
	public void update(Skip skip) {
	
		
		skipDao.update(skip);
	}
	
	
}
