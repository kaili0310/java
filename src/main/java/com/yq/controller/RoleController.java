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
	//��ӽ�ɫ
	@RequestMapping("/save.do") 
	public String save(Role role) { 
	roleService.save(role); 
	return "redirect:findAll.do?page=1&size=3"; 
	}
	//�ͻ�����ҳ
	@RequestMapping("/findById.do")
	public String findById(String id,ModelMap mode){
			Role role=roleService.findById(id);
			mode.put("role", role);
			return "role-show";
	}
	//���ݽ�ɫID��ѯ�û�����ѯû�е�Ȩ��
		@RequestMapping("/findRoleByIdAndAllPer.do")
		public String findRoleByIdAndAllPer(String roleid,ModelMap model) {
			Role role=roleService.findById(roleid);
			List<Permission> permissionList=permissionService.findOtherPermission(roleid);
			model.put("role", role);
			model.put("permissionList", permissionList);
			return "role-premission-add";
	}
		//�����û�ID��Ӹ��û�û�еĽ�ɫ
		@RequestMapping("/addPermissionToRole.do")
		public String addPermissionToRole(String roleId,String[] ids){
			roleService.addPermissionToRole(roleId, ids); 
			return "redirect: findAll.do?page=1&size=3";
		}
		
		
	
}
