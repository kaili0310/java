package com.yq.entity;
//��������Ϣ���� orders
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {
	
	private String id;//�����塢����uuid
	private String orderNum;//������� ��Ϊ�� Ψһ
	private Date   orderTime;//�µ�ʱ��
	private String orderTimeStr;//
	private int orderStatus;//����״̬(0 δ֧�� 1 ��֧��)
	private String orderStatusStr;//
	private int peopleCount;//��������
	private Integer payType;//֧����ʽ(0 ֧���� 1 ΢�� 2����)
	private String  payTypeStr;//
	private String orderDesc;//��������(������Ϣ)
    //	
	private Product product;//��Ʒ�����orders(many��)product(one��)
	private List<Traveller> travellers;//
	private Member member;//��Ա�����memberid
	
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
			return "֧����";
		}else if(this.payType==1) {
			return "΢��";
		}else {
			return "����";
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
			return "δ֧��";
		return "��֧��";
	}
	public void setOrderStatusStr(String orderStatusStr) {
		this.orderStatusStr = orderStatusStr;
	}
	
}
