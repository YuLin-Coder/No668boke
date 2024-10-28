package com.service;

import java.util.List;
import com.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.BloggerMapper;

/**
 * 用户Service实现类
 */
@Service
public class BloggerServiceImpl implements BloggerService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private BloggerMapper bloggerMapper;

	/**
	 * 查询用户记录数
	 * 
	 * @param blogger
	 * @return
	 */
	public int getCount(Blogger blogger) {
		Map<String, Object> map = getQueryMap(blogger, null);
		return bloggerMapper.getCount(map);
	}

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<Blogger> queryBloggerList(Blogger blogger, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(blogger, page);
		List<Blogger> list = bloggerMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param blogger
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Blogger blogger, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (blogger != null) {
			map.put("id", blogger.getId());
			map.put("username", blogger.getUsername());
			map.put("password", blogger.getPassword());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存用户
	 * 
	 * @param blogger
	 * @return
	 */
	public int insertBlogger(Blogger blogger) throws Exception {
		return bloggerMapper.insertBlogger(blogger);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlogger(int id) throws Exception {
		return bloggerMapper.deleteBlogger(id);
	}

	/**
	 * 更新用户
	 * 
	 * @param blogger
	 * @return
	 */
	public int updateBlogger(Blogger blogger) throws Exception {
		return bloggerMapper.updateBlogger(blogger);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blogger queryBloggerById(int id) throws Exception {
		return bloggerMapper.queryBloggerById(id);
	}
}
