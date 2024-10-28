package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Blogtype;

public interface BlogtypeMapper {
	/**
	 * 查询所有分类
	 * 
	 * @return
	 */
	public List<Blogtype> query(Map<String, Object> inputParam);

	/**
	 * 查询分类记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存分类
	 * 
	 * @param blogtype
	 * @return
	 */
	public int insertBlogtype(Blogtype blogtype);

	/**
	 * 删除分类
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlogtype(int id);

	/**
	 * 更新分类
	 * 
	 * @param blogtype
	 * @return
	 */
	public int updateBlogtype(Blogtype blogtype);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blogtype queryBlogtypeById(int id);
	
	/**
	 * 获取博客类别信息
	 */
	public List<Blogtype> getBlogTypeData(Integer uid);
}
