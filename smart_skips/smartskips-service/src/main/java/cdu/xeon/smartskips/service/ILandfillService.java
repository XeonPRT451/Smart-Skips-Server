package cdu.xeon.smartskips.service;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.smartskips.model.Landfill;



public interface ILandfillService {
	
	public void add(Landfill landfill);
	
	public void delete(int id);
	
	public void updateStatus(int id);
	
	
	public Pager<Landfill> findLandfill();
	
	public Landfill load(int id);
	
	public void update(Landfill landfill, int did);

}
