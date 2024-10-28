package com.service;

import java.util.List;

import com.model.Blogtype;
import com.util.PageBean;

/**
 * 分类Service接口
 */
public interface BlogtypeService {
	/**
	 * 查询分类记录数
	 * 
	 * @param blogtype
	 * @return
	 */
	public int getCount(Blogtype blogtype);

	/**
	 * 查询所有分类
	 * 
	 * @return
	 */
	public List<Blogtype> queryBlogtypeList(Blogtype blogtype, PageBean page)
			throws Exception;

	/**
	 * 保存分类
	 * 
	 * @param blogtype
	 * @return
	 */
	public int insertBlogtype(Blogtype blogtype) throws Exception;

	/**
	 * 删除分类
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlogtype(int id) throws Exception;

	/**
	 * 更新分类
	 * 
	 * @param blogtype
	 * @return
	 */
	public int updateBlogtype(Blogtype blogtype) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blogtype queryBlogtypeById(int id) throws Exception;
	
	public List<Blogtype> getBlogTypeData(Integer uid);
}
