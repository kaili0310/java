package com.yq.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import com.yq.entity.User;

public interface IUserDaoMapper {
	/*@Select("select * from users where username=#{username}")
	public User getUserByName(String username);*/
	
	//��¼
	@Select("select * from users where username=#{username}")
		 @Results({
		 @Result(id = true, property = "id", column = "id"),
		 @Result(column = "username", property = "username"),
		 @Result(column = "email", property = "email"), 
		 @Result(column = "password", property = "password"),
		 @Result(column = "phoneNum", property = "phoneNum"), 
		 @Result(column = "status", property = "status"),
		 @Result(column = "id", property = "roles", javaType = List.class, many = 
		 @Many(select = "com.yq.mapper.IRoleDaoMapper.findRoleByUserId"))
	})
	 public User findByUsername(String username);
	
	//��ѯ�����û�
	@Select("select * from users")
	public List<User> findAll();
	//����û�
	@Insert("insert into users values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
	public void save(com.yq.entity.User user);
	//�û�����
	@Select("select * from users where id=#{id}")
	@Results({ 
		@Result(id = true, property = "id", column = "id"), 
		@Result(column = "username", property = "username"),
		@Result(column = "email", property = "email"),
		@Result(column = "password", property = "password"),
		@Result(column = "phoneNum", property = "phoneNum"), 
		@Result(column = "status", property = "status"),
		@Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.yq.mapper.IRoleDaoMapper.findRoleByUserId") ) })
	public User finAllById(String id);
	
	//���м����ӽ�ɫ���û��Ĺ�ϵ
	@Insert("insert into users_role values (#{userId},#{roleId})")
	public void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}

