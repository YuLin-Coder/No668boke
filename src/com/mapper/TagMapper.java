package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Tag;

public interface TagMapper {
	/**
	 * 查询所有标签
	 * 
	 * @return
	 */
	public List<Tag> query(Map<String, Object> inputParam);

	/**
	 * 查询标签记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存标签
	 * 
	 * @param tag
	 * @return
	 */
	public int insertTag(Tag tag);

	/**
	 * 删除标签
	 * 
	 * @param id
	 * @return
	 */
	public int deleteTag(int id);

	/**
	 * 更新标签
	 * 
	 * @param tag
	 * @return
	 */
	public int updateTag(Tag tag);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Tag queryTagById(int id);
	
	/**
	 * 获取博客类别信息
	 */
	public List<Tag> getBlogTypeData(Integer uid);
}
