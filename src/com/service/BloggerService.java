package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Blogger;

/**
 * 用户Service接口
 */
public interface BloggerService {
	/**
	 * 查询用户记录数
	 * 
	 * @param blogger
	 * @return
	 */
	public int getCount(Blogger blogger);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<Blogger> queryBloggerList(Blogger blogger, PageBean page)
			throws Exception;

	/**
	 * 保存用户
	 * 
	 * @param blogger
	 * @return
	 */
	public int insertBlogger(Blogger blogger) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlogger(int id) throws Exception;

	/**
	 * 更新用户
	 * 
	 * @param blogger
	 * @return
	 */
	public int updateBlogger(Blogger blogger) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blogger queryBloggerById(int id) throws Exception;
}
