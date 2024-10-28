package com.model;

import java.io.Serializable;

/**
 * 日志Model类
 */
public class Rizhi implements Serializable{
	public Rizhi() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 用户
	 */
	private Integer uid;
	
	private Blogger userVO;
	/**
	 * 登录日期
	 */
	private String cdate;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public Blogger getUserVO() {
		return userVO;
	}

	public void setUserVO(Blogger userVO) {
		this.userVO = userVO;
	}
	
	
}
