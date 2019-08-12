package com.yq.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	private String id; // 主键
	private String productNum; // 编号 唯一
	private String productName; // 名称
	private String cityName; // 出发城市
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date departureTime; // 出发时间
	private String departureTimeStr;//为了格式化日期
	private double productPrice; // 产品价格
	private String productDesc; // 产品描述
	private Integer productStatus; // 状态 0 关闭 1 开启
	private String productStatusStr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public String getDepartureTimeStr() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return sdf.format(this.departureTime);
	}
	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductStatusStr() {
		if(this.productStatus==0) 
			return "关闭";		
		return "开启";
	}
	public void setProductStatusStr(String productStatusStr) {
		
		this.productStatusStr = productStatusStr;
	}
	
}
