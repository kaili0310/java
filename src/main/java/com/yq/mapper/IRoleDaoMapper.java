package com.yq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.yq.entity.Role;
public interface IRoleDaoMapper {
	@Select("select * from role where id in( select roleId from users_role where userId=#{userId})")
	@Results({
		@Result(column="id",property="permissions",
				many=@Many(select="com.yq.mapper.IPermissionDaoMapper.findByRoleId")) 
	})
	public List<Role> findRoleByUserId(String userId);
	
	//查询所有角色
	@Select("Select * from role")
	public List<Role> findAll();
	//添加角色
	@Insert("insert into role value(#{id},#{roleName},#{roleDesc})")
	public void save(Role role);
	//根据ID查询该ID没有的角色
	@Select("SELECT * FROM role WHERE id NOT IN(SELECT roleId FROM users_role WHERE userId=#{id})")
	public List<Role> findOtherRoles(String id);
	
	
	@Select("select * from role where id=#{roleid}")
	@Results({
		@Result(id=true,column="id",property="id"), 
		@Result(column="roleName",property="roleName"), 
		@Result(column="roleDesc",property="roleDesc"), 
		@Result(column="id",property="permissions",
				many=@Many(select="com.yq.mapper.IPermissionDaoMapper.findByRoleId")) 
	})
	public Role findById(String roleid);
	
	
	@Insert("insert into role_permission values (#{permissionId},#{roleId})") 
	public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
	
}
