package com.model;

import java.io.Serializable;

/**
 * 关注Model类
 */
public class Fav implements Serializable{
	public Fav() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * uid
	 */
	private Integer uid;
	/**
	 * bzid
	 */
	private Integer bzid;
	/**
	 * cdate
	 */
	private String cdate;
	private Blogger bloggerVO;
	
	private Blogger userVO;

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

	public Integer getBzid() {
		return this.bzid;
	}

	public void setBzid(Integer bzid) {
		this.bzid = bzid;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public Blogger getBloggerVO() {
		return this.bloggerVO;
	}

	public void setBloggerVO(Blogger bloggerVO) {
		this.bloggerVO = bloggerVO;
	}

	public Blogger getUserVO() {
		return userVO;
	}

	public void setUserVO(Blogger userVO) {
		this.userVO = userVO;
	}
	
	
	
}
