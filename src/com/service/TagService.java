package com.service;

import java.util.List;

import com.model.Tag;
import com.util.PageBean;

/**
 * 标签Service接口
 */
public interface TagService {
	/**
	 * 查询标签记录数
	 * 
	 * @param tag
	 * @return
	 */
	public int getCount(Tag tag);

	/**
	 * 查询所有标签
	 * 
	 * @return
	 */
	public List<Tag> queryTagList(Tag tag, PageBean page)
			throws Exception;

	/**
	 * 保存标签
	 * 
	 * @param tag
	 * @return
	 */
	public int insertTag(Tag tag) throws Exception;

	/**
	 * 删除标签
	 * 
	 * @param id
	 * @return
	 */
	public int deleteTag(int id) throws Exception;

	/**
	 * 更新标签
	 * 
	 * @param tag
	 * @return
	 */
	public int updateTag(Tag tag) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Tag queryTagById(int id) throws Exception;
	
	public List<Tag> getBlogTypeData(Integer uid);
}
