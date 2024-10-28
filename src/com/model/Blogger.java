package com.model;

import java.io.Serializable;

/**
 * 用户Model类
 */
public class Blogger implements Serializable{
	public Blogger() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 账号
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 个人主页
	 */
	private String profile;
	/**
	 * 姓名昵称
	 */
	private String nickname;
	/**
	 * 个人签名
	 */
	private String sign;
	/**
	 * 头像
	 */
	private String imagename;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getImagename() {
		return this.imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
}
