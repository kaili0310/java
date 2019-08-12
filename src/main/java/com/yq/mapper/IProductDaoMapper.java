package com.yq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yq.entity.Product;

public interface IProductDaoMapper {
	//查询所有方法
	@Select("select * from product")
	public List<Product> findAll();
	
	//添加方法product
	@Insert("insert into product values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
	public int save(Product product);
	
	@Select("select * from product where id=#{id}")
	public Product getProductById(String id);
	
	//删除方法
	@Delete("<script>" +
            "delete from product" +
            "<where>" + "id in"+
            "<foreach collection='array' item='id' index='' open='(' separator=',' close=')'>"+
            	"#{id}"
            +"</foreach>"+
            "</where>" +
            "</script>"
 )
	public int delProductById(String[]ids);
}
