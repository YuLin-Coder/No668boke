package com.mapper;

import com.model.Blogger;
import java.util.List;
import java.util.Map;

public interface BloggerMapper {
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<Blogger> query(Map<String, Object> inputParam);

	/**
	 * 查询用户记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存用户
	 * 
	 * @param blogger
	 * @return
	 */
	public int insertBlogger(Blogger blogger);

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlogger(int id);

	/**
	 * 更新用户
	 * 
	 * @param blogger
	 * @return
	 */
	public int updateBlogger(Blogger blogger);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blogger queryBloggerById(int id);
}
