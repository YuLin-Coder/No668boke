package com.model;

import java.io.Serializable;

/**
 * 评论Model类
 */
public class Comment implements Serializable{
	public Comment() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 用户
	 */
	private Integer userid;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 评论时间
	 */
	private String cdate;
	/**
	 * 评论状态
	 */
	private Integer state;
	/**
	 * 博客
	 */
	private Integer blogid;
	/**
	 * 评论人
	 */
	private String uname;
	private Blogger bloggerVO;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getBlogid() {
		return this.blogid;
	}

	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Blogger getBloggerVO() {
		return this.bloggerVO;
	}

	public void setBloggerVO(Blogger bloggerVO) {
		this.bloggerVO = bloggerVO;
	}
}
