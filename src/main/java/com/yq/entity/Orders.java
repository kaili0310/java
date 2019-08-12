package com.yq.entity;
//订单表信息描述 orders
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {
	
	private String id;//无意义、主键uuid
	private String orderNum;//订单编号 不为空 唯一
	private Date   orderTime;//下单时间
	private String orderTimeStr;//
	private int orderStatus;//订单状态(0 未支付 1 已支付)
	private String orderStatusStr;//
	private int peopleCount;//出行人数
	private Integer payType;//支付方式(0 支付宝 1 微信 2其它)
	private String  payTypeStr;//
	private String orderDesc;//订单描述(其它信息)
    //	
	private Product product;//产品的外键orders(many方)product(one方)
	private List<Traveller> travellers;//
	private Member member;//会员的外键memberid
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderTimeStr() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return sdf.format(this.orderTime);
	}
	public void setOrderTimeStr(String orderTimeStr) {
		this.orderTimeStr = orderTimeStr;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Traveller> getTravellers() {
		return travellers;
	}
	public void setTravellers(List<Traveller> travellers) {
		this.travellers = travellers;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getPayTypeStr() {
		if(this.payType==0) {
			return "支付宝";
		}else if(this.payType==1) {
			return "微信";
		}else {
			return "其他";
		}
	}
	public void setPayTypeStr(String payTypeStr) {
		this.payTypeStr = payTypeStr;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public String getOrderStatusStr() {
		if(this.orderStatus==0) 
			return "未支付";
		return "已支付";
	}
	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
	}
	
}
