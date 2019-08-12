package com.yq.entity;

import java.util.List;
//�û�����Ϣ����users
public class User {
	private String id;//�����壬����uuid
	private String username;//�û���
	private String email;//�ǿգ�Ψһ
	private String password;//���루���ܣ�
	private String phoneNum;//�绰
	private int status;//״̬0 δ���� 1 ����
	private String statusStr;
	
	private List<Role> roles;//��ɫ�ļ���
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusStr() {
		if(this.status==0)
			return "�ر�";
		return "����";
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
