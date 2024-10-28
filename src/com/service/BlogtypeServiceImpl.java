package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.BlogtypeMapper;
import com.model.Blogtype;
import com.util.PageBean;

/**
 * 分类Service实现类
 */
@Service
public class BlogtypeServiceImpl implements BlogtypeService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private BlogtypeMapper blogtypeMapper;

	/**
	 * 查询分类记录数
	 * 
	 * @param blogtype
	 * @return
	 */
	public int getCount(Blogtype blogtype) {
		Map<String, Object> map = getQueryMap(blogtype, null);
		return blogtypeMapper.getCount(map);
	}

	/**
	 * 查询所有分类
	 * 
	 * @return
	 */
	public List<Blogtype> queryBlogtypeList(Blogtype blogtype, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(blogtype, page);
		List<Blogtype> list = blogtypeMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param blogtype
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Blogtype blogtype, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (blogtype != null) {
			map.put("id", blogtype.getId());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存分类
	 * 
	 * @param blogtype
	 * @return
	 */
	public int insertBlogtype(Blogtype blogtype) throws Exception {
		return blogtypeMapper.insertBlogtype(blogtype);
	}

	/**
	 * 删除分类
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlogtype(int id) throws Exception {
		return blogtypeMapper.deleteBlogtype(id);
	}

	/**
	 * 更新分类
	 * 
	 * @param blogtype
	 * @return
	 */
	public int updateBlogtype(Blogtype blogtype) throws Exception {
		return blogtypeMapper.updateBlogtype(blogtype);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blogtype queryBlogtypeById(int id) throws Exception {
		return blogtypeMapper.queryBlogtypeById(id);
	}
	
	public List<Blogtype> getBlogTypeData(Integer uid) {
		return blogtypeMapper.getBlogTypeData(uid);
	}
}
