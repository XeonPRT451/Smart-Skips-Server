package cdu.xeon.smartskips.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.basic.util.JsonUtil;
import cdu.xeon.smartskips.model.Operator;
import cdu.xeon.smartskips.service.IOperatorService;

@Controller
@RequestMapping("/operator")
public class OperatorController {
	
	private IOperatorService operatorService;
	
	

	public IOperatorService getOperatorService() {
		return operatorService;
	}


   @Inject
	public void setOperatorService(IOperatorService operatorService) {
		this.operatorService = operatorService;
	}



	@RequestMapping("/mobileList")  
	public void list(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		int lid = Integer.parseInt(request.getParameter("lid")); 
		Pager<Operator> po = operatorService.findOndutyOperator(lid);
		List<Operator> lo=po.getDatas();
		response.setContentType("application/json");
		try {
			response.getWriter().write(JsonUtil.getInstance().obj2json(lo));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
