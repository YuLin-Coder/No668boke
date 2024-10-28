package com.model;

import java.io.Serializable;

/**
 * 分类Model类
 */
public class Blogtype implements Serializable{
	public Blogtype() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 分类名称
	 */
	private String typename;
	private Integer blogCount;
	
	
	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}
	
	
}
