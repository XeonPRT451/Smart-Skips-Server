package cdu.xeon.smartskips.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.basic.util.JsonUtil;
import cdu.xeon.smartskips.model.Skip;
import cdu.xeon.smartskips.service.ISkipService;


@Controller
@RequestMapping("/skip")
public class SkipController {
	
	private ISkipService skipService;
	
	

	public ISkipService getSkipService() {
		return skipService;
	}


    @Inject
	public void setSkipService(ISkipService skipService) {
		this.skipService = skipService;
	}

    @RequestMapping("/find")
	public String find(Model model,HttpSession session) {
		
	   Pager<Skip> skips=skipService.findSkip();
	   model.addAttribute("datas", skips);
		return "skip/list";
	}

	@RequestMapping("/mobileList")  
	public void list(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		
		Pager<Skip> ps = skipService.findSkip();
		List<Skip> ls=ps.getDatas();
		response.setContentType("application/json");
		try {
			response.getWriter().write(JsonUtil.getInstance().obj2json(ls));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@RequestMapping("/mobileUpdate")
	public void update(HttpServletRequest request, HttpServletResponse response,ModelMap model) {
		Skip ns=(Skip)request.getAttribute("skip");
		
		Skip os=skipService.load(ns.getId());
		os.setCurrentCapacity(ns.getCurrentCapacity());
		os.setFull(ns.getFull());
		os.setLocation(ns.getLocation());
		skipService.update(os);
		
		try {
			response.getWriter().write(JsonUtil.getInstance().obj2json("success"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
}
