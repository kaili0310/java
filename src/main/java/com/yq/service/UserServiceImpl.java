package com.yq.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yq.entity.Role;
import com.yq.mapper.IUserDaoMapper;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDaoMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDetails loadUserByUsername(String username)  {
		// TODO Auto-generated method stub
		com.yq.entity.User db_user=userMapper.findByUsername(username);
		List<Role> roles = db_user.getRoles();
		User user=new User(db_user.getUsername(),db_user.getPassword(),db_user.getStatus()==1?true:false,true,true,true,getAuthority(roles));
		return user;
	}
	public List<GrantedAuthority> getAuthority(List<Role> roles){
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			 list.add(new SimpleGrantedAuthority(role.getRoleName()));
		 }
		return list;
	}
	//��ѯ�����û�
	public List<com.yq.entity.User> findAll(int page,int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return userMapper.findAll();
	}
	//�����û�
	public void save(com.yq.entity.User user) {
		//�������id
		user.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		//��������м��ܲ���
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMapper.save(user);
	}
	//�û�����
	public com.yq.entity.User findById(String id) {
		// TODO Auto-generated method stub
		return userMapper.finAllById(id);
	}
	//��ӽ�ɫ���û�
	public void addRoleToUser(String userId, String[] ids) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ids.length; i++) {
			userMapper.addRoleToUser(userId,ids[i]);
		}
	}
	
}
