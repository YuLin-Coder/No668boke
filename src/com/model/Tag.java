package com.model;

import java.io.Serializable;

/**
 * 标签Model类
 */
public class Tag implements Serializable{
	public Tag() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 标签名称
	 */
	private String tagname;
	
	
	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	
	
	
}
