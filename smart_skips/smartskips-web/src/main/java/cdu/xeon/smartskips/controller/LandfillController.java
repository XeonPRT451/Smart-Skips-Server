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
import cdu.xeon.smartskips.model.Landfill;

import cdu.xeon.smartskips.service.ILandfillService;

@Controller
@RequestMapping("/landfill")
public class LandfillController {
	
	private ILandfillService landfillService;

	public ILandfillService getLandfillService() {
		return landfillService;
	}
	
   @Inject
	public void setLandfillService(ILandfillService landfillService) {
		this.landfillService = landfillService;
	}
	
	@RequestMapping("/mobileList")  
	public void list(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		Pager<Landfill> pl = landfillService.findLandfill();
		List<Landfill> ll=pl.getDatas();
		
		
		response.setContentType("application/json");
		try {
			response.getWriter().write(JsonUtil.getInstance().obj2json(ll));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
