package cdu.xeon.smartskips.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cdu.xeon.basic.util.JsonUtil;

import cdu.xeon.smartskips.model.Driver;

import cdu.xeon.smartskips.service.IDriverService;

@Controller
@RequestMapping("/driver")
public class DriverController {

private IDriverService driverService;	



	public IDriverService getDriverService() {
	return driverService;
}


	@Inject
    public void setDriverService(IDriverService driverService) {
	this.driverService = driverService;
}



	@RequestMapping(value="/mobileLogin",method=RequestMethod.POST)  
	public void login(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");	
			System.out.println("--------------------------------"+username);
     try {
			Driver d = driverService.login(username, password);
			d.setPassword(null);
			response.setContentType("application/json");
			response.getWriter().write(JsonUtil.getInstance().obj2json(d));
     }
     catch (Exception e) {
    	 e.printStackTrace();
    	 }
	}


	
	@RequestMapping("/mobileUpdate")  
	public void update(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		String json = request.getParameter("driver");
		Driver nd=(Driver)JsonUtil.getInstance().json2obj(json, Driver.class);
		Driver od = driverService.load(nd.getId());
		od.setNickname(nd.getNickname());
		od.setPhone(nd.getPhone());
		od.setEmail(nd.getEmail());
		System.out.println(od);
		
		driverService.update(od);
		try {
			response.getWriter().write(JsonUtil.getInstance().obj2json("success"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	@RequestMapping("/mobilePickupSkip")  
	public void pickupSkip(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		int did = Integer.parseInt(request.getParameter("did"));
		int sid = Integer.parseInt(request.getParameter("sid")); 
		
	
		driverService.updatePickupSkip(did, sid);
		try {
			response.getWriter().write(JsonUtil.getInstance().obj2json("success"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	@RequestMapping("/mobileEmptySkip")  
	public void emptySkip(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		int did = Integer.parseInt(request.getParameter("did")); 
		int lid = Integer.parseInt(request.getParameter("lid")); 
		
		driverService.updateEmptySkip(did, lid);
		try {
			response.getWriter().write(JsonUtil.getInstance().obj2json("success"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
		@RequestMapping("/mobileUpdatePwd")  
	public void updatePwd(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
			int did = Integer.parseInt(request.getParameter("did")); 
			String oldPwd = request.getParameter("oldPwd");
			String newPwd = request.getParameter("newPwd");	
			System.out.println(did);
			driverService.updatePwd(did, oldPwd, newPwd);
			response.setContentType("application/json");
			try {
				response.getWriter().write(JsonUtil.getInstance().obj2json("success"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		@RequestMapping("/mobileLoad")
		public void load(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
			int did = Integer.parseInt(request.getParameter("did")); 
			Driver d = driverService.load(did);
			System.out.println(d);
			d.setPassword(null);
			response.setContentType("application/json");
			try {
				response.getWriter().write(JsonUtil.getInstance().obj2json(d));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
}
		
}
