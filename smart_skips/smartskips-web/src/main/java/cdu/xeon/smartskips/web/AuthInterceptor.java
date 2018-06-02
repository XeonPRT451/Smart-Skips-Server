package cdu.xeon.smartskips.web;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdu.xeon.smartskips.model.Driver;
import cdu.xeon.smartskips.model.SmartskipsException;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		String sid = request.getParameter("sid");
		if(sid!=null&&!"".equals(sid.trim())) {
			session = SmartskipsSessionContext.getSession(sid);
		}
		HandlerMethod hm = (HandlerMethod)handler;
		Driver driver = (Driver)session.getAttribute("loginUser");
		if(driver==null) {
			response.sendRedirect(request.getContextPath()+"/login");
		} else {
			boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
			if(!isAdmin) {
				Set<String> actions = (Set<String>)session.getAttribute("allActions");
				String aname = hm.getBean().getClass().getName()+"."+hm.getMethod().getName();
				if(!actions.contains(aname)) throw new SmartskipsException("There is no permission to access this feature");
			}
		}
		return super.preHandle(request, response, handler);
	}
}
