package com.yq.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yq.entity.Role;
import com.yq.mapper.IRoleDaoMapper;
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDaoMapper roleMapper;
	public List<Role> findAll(int page,int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return roleMapper.findAll();
	}
	
	//根据用户ID查询该用户没有的角色
		public List<Role> findOtherRoles(String id) {
			// TODO Auto-generated method stub
			return roleMapper.findOtherRoles(id);
		}
	public void save(Role role) {
		// TODO Auto-generated method stub
		//生成随机id
		role.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		roleMapper.save(role);
	}

	public Role findById(String roleid) {
		return roleMapper.findById(roleid);
	}

	public void addPermissionToRole(String roleId, String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			roleMapper.addPermissionToRole(roleId,ids[i]);
		}
		
	}

}
