package com.yq.controller;


import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.github.pagehelper.PageInfo;
import com.yq.entity.Role;
import com.yq.entity.User;
import com.yq.service.IRoleService;
import com.yq.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/findAll.do")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String findAll(int page,int size,ModelMap model){
		List<User> users = userService.findAll(page,size);
		PageInfo pageInfo=new PageInfo(users);
		model.put("pageInfo", pageInfo);
		return "user-list";
	}
	//保存客户
	@RequestMapping("/save.do")
	public String save(User user){
		userService.save(user);
		return "redirect:findAll.do?page=1&size=3";
	}
	//客户详情页
		@RequestMapping("/findById.do")
		public String findById(String id,ModelMap mode){
			User users=userService.findById(id);
			mode.put("user", users);
			return "user-show";
		}
	//根据用户ID查询用户，查询没有的角色
	@RequestMapping("/findUserByIdAndAllRole.do")
	public String findUserByIdAndAllRole(String id,ModelMap model) {
		User users=userService.findById(id);
		List<Role> roles=roleService.findOtherRoles(id);
		model.put("user", users);
		model.put("roleList", roles);
		return "user-role-add";
	}
	//根据用户ID添加该用户没有的角色
	@RequestMapping("/addRoleToUser.do")
	public String addRoleToUser(String userId,String[] ids){
	
		userService.addRoleToUser(userId,ids);
		return "redirect: findAll.do?page=1&size=3";
	}
}
