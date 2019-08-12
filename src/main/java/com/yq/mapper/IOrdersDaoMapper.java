package com.yq.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yq.entity.Orders;

public interface IOrdersDaoMapper {
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "orderNum",property = "orderNum"),
		@Result(column = "orderTime",property = "orderTime"),
		@Result(column = "orderStatus",property = "orderStatus"),
		@Result(column = "peopleCount",property = "peopleCount"),
		@Result(column = "payType",property = "payType"),
		@Result(column = "orderDesc",property = "orderDesc"),
		@Result(column = "productId",property = "product",one = @One(select =
		"com.yq.mapper.IProductDaoMapper.getProductById"))
	})
	@Select("select * from orders")
	public List<Orders> findAll();//关联查询订单与产品
	
	
	
	@Results({
		@Result(id=true,column = "id",property = "id"),
		@Result(column = "orderNum",property = "orderNum"),
		@Result(column = "orderTime",property = "orderTime"),
		@Result(column = "orderStatus",property = "orderStatus"),
		@Result(column = "peopleCount",property = "peopleCount"),
		@Result(column = "payType",property = "payType"),
		@Result(column = "orderDesc",property = "orderDesc"),
		@Result(column = "productId",property = "product",one = @One(select =
		"com.yq.mapper.IProductDaoMapper.getProductById")),
		@Result(column = "memberId",property = "member",one = @One(select =
		"com.yq.mapper.IMemberDaoMapper.getMemberById")),
		@Result(column = "id",property = "travellers",many = @Many(select =
		"com.yq.mapper.ITravellerDaoMapper.getByOrdersId"))
	})
	@Select("select * from orders where id=#{id}")
	public Orders findById(String id);//关联查询订单,订单详情，旅客信息。
	
	
	
	
	
}
