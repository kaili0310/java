package com.yq.service;

import java.util.List;

import com.yq.entity.Role;

public interface IRoleService {
	public List<Role> findAll(int page,int size);

	public void save(Role role);
	public List<Role> findOtherRoles(String id);//�����û�ID��ѯ���û�û�еĽ�ɫ

	public Role findById(String roleid);

	public void addPermissionToRole(String roleId, String[] ids);
}
