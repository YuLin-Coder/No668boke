package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.LikeMapper;
import com.model.Like;
import com.util.PageBean;

/**
 * 点赞Service实现类
 */
@Service
public class LikeServiceImpl implements LikeService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private LikeMapper likeMapper;

	/**
	 * 查询点赞记录数
	 * 
	 * @param like
	 * @return
	 */
	public int getCount(Like like) {
		Map<String, Object> map = getQueryMap(like, null);
		return likeMapper.getCount(map);
	}

	/**
	 * 查询所有点赞
	 * 
	 * @return
	 */
	public List<Like> queryLikeList(Like like, PageBean page) throws Exception {
		Map<String, Object> map = getQueryMap(like, page);
		List<Like> list = likeMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param like
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Like like, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (like != null) {
			map.put("id", like.getId());
			map.put("uid", like.getUid());
			map.put("bkid", like.getBkid());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存点赞
	 * 
	 * @param like
	 * @return
	 */
	public int insertLike(Like like) throws Exception {
		return likeMapper.insertLike(like);
	}

	/**
	 * 删除点赞
	 * 
	 * @param id
	 * @return
	 */
	public int deleteLike(int id) throws Exception {
		return likeMapper.deleteLike(id);
	}

	/**
	 * 更新点赞
	 * 
	 * @param like
	 * @return
	 */
	public int updateLike(Like like) throws Exception {
		return likeMapper.updateLike(like);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Like queryLikeById(int id) throws Exception {
		return likeMapper.queryLikeById(id);
	}

	@Override
	public int deleteLike(int uid, int bkid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("uid", uid);
		map.put("bkid", bkid);
		return likeMapper.delLike(map);
	}
}
