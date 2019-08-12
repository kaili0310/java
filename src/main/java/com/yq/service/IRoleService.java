package com.yq.service;

import java.util.List;

import com.yq.entity.Role;

public interface IRoleService {
	public List<Role> findAll(int page,int size);

	public void save(Role role);
	public List<Role> findOtherRoles(String id);//根据用户ID查询该用户没有的角色

	public Role findById(String roleid);

	public void addPermissionToRole(String roleId, String[] ids);
}
