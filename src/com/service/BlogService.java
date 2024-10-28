package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Blog;

/**
 * 博客Service接口
 */
public interface BlogService {
	/**
	 * 查询博客记录数
	 * 
	 * @param blog
	 * @return
	 */
	public int getCount(Blog blog);

	/**
	 * 查询所有博客
	 * 
	 * @return
	 */
	public List<Blog> queryBlogList(Blog blog, PageBean page) throws Exception;
	
	public Blog getPrevBlog(int id,Integer uid) throws Exception;
	
	public Blog getNextBlog(int id,Integer uid) throws Exception;

	/**
	 * 保存博客
	 * 
	 * @param blog
	 * @return
	 */
	public int insertBlog(Blog blog) throws Exception;

	/**
	 * 删除博客
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlog(int id) throws Exception;

	/**
	 * 更新博客
	 * 
	 * @param blog
	 * @return
	 */
	public int updateBlog(Blog blog) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blog queryBlogById(int id) throws Exception;
}
