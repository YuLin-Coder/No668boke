package com.model;

import java.io.Serializable;

/**
 * 点赞Model类
 */
public class Like implements Serializable{
	public Like() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 用户
	 */
	private Integer uid;
	/**
	 * 博客
	 */
	private Integer bkid;
	/**
	 * 点赞时间
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

	public Integer getBkid() {
		return this.bkid;
	}

	public void setBkid(Integer bkid) {
		this.bkid = bkid;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
}
