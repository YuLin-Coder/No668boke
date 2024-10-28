package com.service;

import java.util.List;
import com.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.BlogMapper;

/**
 * 博客Service实现类
 */
@Service
public class BlogServiceImpl implements BlogService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private BlogMapper blogMapper;

	/**
	 * 查询博客记录数
	 * 
	 * @param blog
	 * @return
	 */
	public int getCount(Blog blog) {
		Map<String, Object> map = getQueryMap(blog, null);
		return blogMapper.getCount(map);
	}

	/**
	 * 查询所有博客
	 * 
	 * @return
	 */
	public List<Blog> queryBlogList(Blog blog, PageBean page) throws Exception {
		Map<String, Object> map = getQueryMap(blog, page);
		List<Blog> list = blogMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param blog
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Blog blog, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (blog != null) {
			map.put("id", blog.getId());
			map.put("uid", blog.getUid());
			map.put("title", blog.getTitle());
			map.put("keyword", blog.getKeyword());
			map.put("typeid", blog.getTypeid());
			map.put("tagid", blog.getTagid());
			map.put("xq", blog.getXq());
			map.put("fx", blog.getFx());
			map.put("nextid", blog.getNextid());
			
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存博客
	 * 
	 * @param blog
	 * @return
	 */
	public int insertBlog(Blog blog) throws Exception {
		return blogMapper.insertBlog(blog);
	}

	/**
	 * 删除博客
	 * 
	 * @param id
	 * @return
	 */
	public int deleteBlog(int id) throws Exception {
		return blogMapper.deleteBlog(id);
	}

	/**
	 * 更新博客
	 * 
	 * @param blog
	 * @return
	 */
	public int updateBlog(Blog blog) throws Exception {
		return blogMapper.updateBlog(blog);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Blog queryBlogById(int id) throws Exception {
		return blogMapper.queryBlogById(id);
	}

	@Override
	public Blog getPrevBlog(int id, Integer uid) throws Exception {

		return getNext(id, uid, -1);
	}

	private Blog getNext(int id, Integer uid,int fx) throws Exception{
		PageBean page = new PageBean(0,1);
		Blog blog = new Blog();
		blog.setFx(fx);
		blog.setUid(uid);
		blog.setNextid(id);
		List<Blog> list = queryBlogList(blog, page);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	@Override
	public Blog getNextBlog(int id, Integer uid) throws Exception {
		return getNext(id, uid, 1);
	}
}
