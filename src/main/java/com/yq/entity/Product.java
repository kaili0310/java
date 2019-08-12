package com.yq.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	private String id; // ����
	private String productNum; // ��� Ψһ
	private String productName; // ����
	private String cityName; // ��������
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date departureTime; // ����ʱ��
	private String departureTimeStr;//Ϊ�˸�ʽ������
	private double productPrice; // ��Ʒ�۸�
	private String productDesc; // ��Ʒ����
	private Integer productStatus; // ״̬ 0 �ر� 1 ����
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
			return "�ر�";		
		return "����";
	}
	public void setProductStatusStr(String productStatusStr) {
		
		this.productStatusStr = productStatusStr;
	}
	
}
