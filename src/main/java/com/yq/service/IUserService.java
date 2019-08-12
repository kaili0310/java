package com.yq.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.yq.entity.Role;
import com.yq.entity.User;

public interface IUserService extends UserDetailsService {
	public List<User> findAll(int page,int size);//分页查询所有用户
	public void save(User user);//保存用户
	public User findById(String id);
	public void addRoleToUser(String userId, String[] ids);//在中间表添加角色与用户的关系
}
