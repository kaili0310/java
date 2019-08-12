package com.yq.service;

import java.util.List;

import com.yq.entity.Permission;


public interface IPermissionService {
	public List<Permission> findAll();
	public void save(Permission permission);
	public List<Permission> findOtherPermission(String roleid);
	
}
