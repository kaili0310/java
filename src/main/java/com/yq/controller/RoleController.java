package com.yq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.yq.entity.Permission;
import com.yq.entity.Role;
import com.yq.entity.User;
import com.yq.service.IPermissionService;
import com.yq.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermissionService permissionService;
	@RequestMapping("/findAll.do")
	public String findAll(int page,int size,ModelMap model){
		List<Role> list=roleService.findAll(page,size);
		PageInfo pageInfo=new PageInfo(list);
		model.put("pageInfo", pageInfo);
		return "role-list";
	}
	//添加角色
	@RequestMapping("/save.do") 
	public String save(Role role) { 
	roleService.save(role); 
	return "redirect:findAll.do?page=1&size=3"; 
	}
	//客户详情页
	@RequestMapping("/findById.do")
	public String findById(String id,ModelMap mode){
			Role role=roleService.findById(id);
			mode.put("role", role);
			return "role-show";
	}
	//根据角色ID查询用户，查询没有的权限
		@RequestMapping("/findRoleByIdAndAllPer.do")
		public String findRoleByIdAndAllPer(String roleid,ModelMap model) {
			Role role=roleService.findById(roleid);
			List<Permission> permissionList=permissionService.findOtherPermission(roleid);
			model.put("role", role);
			model.put("permissionList", permissionList);
			return "role-premission-add";
	}
		//根据用户ID添加该用户没有的角色
		@RequestMapping("/addPermissionToRole.do")
		public String addPermissionToRole(String roleId,String[] ids){
			roleService.addPermissionToRole(roleId, ids); 
			return "redirect: findAll.do?page=1&size=3";
		}
		
		
	
}
