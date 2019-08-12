package com.yq.mapper;

import org.apache.ibatis.annotations.Select;

import com.yq.entity.Member;

public interface IMemberDaoMapper {
	@Select("select * from member where id=#{id}")
	public Member getMemberById(String id);
}
