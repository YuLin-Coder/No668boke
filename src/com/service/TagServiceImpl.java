package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.TagMapper;
import com.model.Tag;
import com.util.PageBean;

/**
 * 标签Service实现类
 */
@Service
public class TagServiceImpl implements TagService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private TagMapper tagMapper;

	/**
	 * 查询标签记录数
	 * 
	 * @param tag
	 * @return
	 */
	public int getCount(Tag tag) {
		Map<String, Object> map = getQueryMap(tag, null);
		return tagMapper.getCount(map);
	}

	/**
	 * 查询所有标签
	 * 
	 * @return
	 */
	public List<Tag> queryTagList(Tag tag, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(tag, page);
		List<Tag> list = tagMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param tag
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Tag tag, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (tag != null) {
			map.put("id", tag.getId());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存标签
	 * 
	 * @param tag
	 * @return
	 */
	public int insertTag(Tag tag) throws Exception {
		return tagMapper.insertTag(tag);
	}

	/**
	 * 删除标签
	 * 
	 * @param id
	 * @return
	 */
	public int deleteTag(int id) throws Exception {
		return tagMapper.deleteTag(id);
	}

	/**
	 * 更新标签
	 * 
	 * @param tag
	 * @return
	 */
	public int updateTag(Tag tag) throws Exception {
		return tagMapper.updateTag(tag);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Tag queryTagById(int id) throws Exception {
		return tagMapper.queryTagById(id);
	}
	
	public List<Tag> getBlogTypeData(Integer uid) {
		return tagMapper.getBlogTypeData(uid);
	}
}
