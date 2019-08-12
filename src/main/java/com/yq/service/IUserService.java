package com.yq.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.yq.entity.Role;
import com.yq.entity.User;

public interface IUserService extends UserDetailsService {
	public List<User> findAll(int page,int size);//��ҳ��ѯ�����û�
	public void save(User user);//�����û�
	public User findById(String id);
	public void addRoleToUser(String userId, String[] ids);//���м����ӽ�ɫ���û��Ĺ�ϵ
}
