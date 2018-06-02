package cdu.xeon.smartskips.web;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cdu.xeon.smartskips.auth.AuthUtil;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static WebApplicationContext wc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		Map<String,Set<String>> auths = AuthUtil.initAuth("cdu.xeon.smartskips.controller");
		this.getServletContext().setAttribute("allAuths", auths);
		
		System.out.println("------------------------System initialization success:"+auths+"-----------------------------");
	}
	
	public static WebApplicationContext getWc() {
		return wc;
	}

}
