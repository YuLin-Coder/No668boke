package com.model;

import java.io.Serializable;

/**
 * 博客Model类
 */
public class Blog implements Serializable{
	public Blog() {
	}

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 博主
	 */
	private Integer uid;
	/**
	 * 博客题目
	 */
	private String title;
	/**
	 * 博客摘要
	 */
	private String summary;
	/**
	 * 发布日期
	 */
	private String cdate;
	/**
	 * 评论次数
	 */
	private Integer clickhit;
	/**
	 * 回复次数
	 */
	private Integer replyhit;
	/**
	 * 点赞次数
	 */
	private Integer likenum;
	/**
	 * 博客内容
	 */
	private String content;
	/**
	 * 关键字
	 */
	private String keyword;
	/**
	 * 分类
	 */
	private Integer typeid;
	
	/**
	 * 标签
	 */
	private Integer tagid;
	/**
	 * 权限
	 */
	private Integer xq;
	private Blogger bloggerVO;
	private Blogtype blogtypeVO;
	private Tag tagVO;
	
	/**
	 * 向上查还是乡下查
	 */
	private Integer fx;
	private Integer nextid;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public Integer getClickhit() {
		return this.clickhit;
	}

	public void setClickhit(Integer clickhit) {
		this.clickhit = clickhit;
	}

	public Integer getReplyhit() {
		return this.replyhit;
	}

	public void setReplyhit(Integer replyhit) {
		this.replyhit = replyhit;
	}

	public Integer getLikenum() {
		return this.likenum;
	}

	public void setLikenum(Integer likenum) {
		this.likenum = likenum;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getXq() {
		return this.xq;
	}

	public void setXq(Integer xq) {
		this.xq = xq;
	}

	public Blogger getBloggerVO() {
		return this.bloggerVO;
	}

	public void setBloggerVO(Blogger bloggerVO) {
		this.bloggerVO = bloggerVO;
	}

	public Blogtype getBlogtypeVO() {
		return this.blogtypeVO;
	}

	public void setBlogtypeVO(Blogtype blogtypeVO) {
		this.blogtypeVO = blogtypeVO;
	}

	public Integer getFx() {
		return fx;
	}

	public void setFx(Integer fx) {
		this.fx = fx;
	}

	public Integer getNextid() {
		return nextid;
	}

	public void setNextid(Integer nextid) {
		this.nextid = nextid;
	}

	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public Tag getTagVO() {
		return tagVO;
	}

	public void setTagVO(Tag tagVO) {
		this.tagVO = tagVO;
	}
	
	
	
}
