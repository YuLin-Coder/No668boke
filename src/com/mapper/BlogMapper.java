package com.mapper;

import com.model.Blog;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
	/**
	 * 查询所有博客
	 * 
	 * @return
	 */
	public List<Blog> query(Map<String, Object> inputParam);

	/**
	 * 查询博客记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存博客
	 * 
	 * @param blog
	 * @return
	 */
	public int insertBlog(Blog blog);

	/**
	 * 删除博客
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlog(int id);

	/**
	 * 更新博客
	 * 
	 * @param blog
	 * @return
	 */
	public int updateBlog(Blog blog);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blog queryBlogById(int id);
}
