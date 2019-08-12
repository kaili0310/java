package com.yq.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yq.entity.Permission;
import com.yq.service.IPermissionService;


@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private IPermissionService permissionService;
	@RequestMapping("/findAll.do")
	public String findAll(ModelMap model){
		List<Permission> list=permissionService.findAll();
		model.put("permissionList", list);
		return "permission-list";
	}
	//Ìí¼Ó½ÇÉ«
	@RequestMapping("/save.do") 
	public String save(Permission permission) { 
		permissionService.save(permission); 
	return "redirect:findAll.do"; 
	}
}
