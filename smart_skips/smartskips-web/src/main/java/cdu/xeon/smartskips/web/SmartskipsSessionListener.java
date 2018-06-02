package cdu.xeon.smartskips.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SmartskipsSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		SmartskipsSessionContext.removeSession(event.getSession());
		System.out.println("remove Session:"+event.getSession().getId());
	}

}
