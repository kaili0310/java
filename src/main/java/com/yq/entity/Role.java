package com.yq.entity;

import java.util.List;
//��ɫ����Ϣ����role
public class Role {
	 private String id;//�����壬����uuid
	 private String roleName;//��ɫ��
	 private String roleDesc;//��ɫ����
	 
	 
	 private List<Permission> permissions;
	 private List<User> users;
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	 
}
