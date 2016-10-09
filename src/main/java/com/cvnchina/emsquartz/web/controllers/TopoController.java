package com.cvnchina.emsquartz.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cvnchina.emsquartz.service.business.NeService;

/**
 * This displays the welcome screen that shows what will be happening in this chapter.
 *
 * @author Rob Winch
 *
 */
//@Controller
//@RequestMapping("/topo")
public class TopoController {
	
	@Autowired
	private NeService neService;
	
	@RequestMapping("getNeNum")
	public Object getNeNum(Model model){
		int num=neService.getNeNum();
		model.addAttribute("data",num);
		model.addAttribute("success","");
		return null;
	}
}