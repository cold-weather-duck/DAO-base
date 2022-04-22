package com.entity;

import java.io.*;

/*
 * ������Ӧ����
 * �ֶ�����Ӧ����
 */
public class Users implements Serializable {
	private Integer usid;// id
	private String uname;// �û���
	private String upwd;// ����
	private String sex;// �Ա�
	private String cardNo;// ����
	private String email;// ����
	private String mobile;// �ֻ���

	public Users() {
	}

	public Users(Integer usid, String uname, String upwd, String sex, String cardNo, String email, String mobile) {
		this.usid = usid;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.cardNo = cardNo;
		this.email = email;
		this.mobile = mobile;
	}

	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Users [usid=" + usid + ", uname=" + uname + ", upwd=" + upwd + ", sex=" + sex + ", cardNo=" + cardNo
				+ ", email=" + email + ", mobile=" + mobile + "]";
	}

}
