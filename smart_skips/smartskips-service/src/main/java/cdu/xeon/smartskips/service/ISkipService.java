package cdu.xeon.smartskips.service;

import cdu.xeon.basic.model.Pager;

import cdu.xeon.smartskips.model.Skip;

public interface ISkipService {
	
public void add(Skip skip);
	
	public void delete(int id);
	
	public void updateStatus(int id);
	
	public void updateFull(int id);
	
	public Pager<Skip> findSkip();
	
	public Skip load(int id);
	
	public void update(Skip skip);

}
