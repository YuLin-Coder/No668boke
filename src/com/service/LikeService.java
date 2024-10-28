package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Like;

/**
 * 点赞Service接口
 */
public interface LikeService {
	/**
	 * 查询点赞记录数
	 * 
	 * @param like
	 * @return
	 */
	public int getCount(Like like);

	/**
	 * 查询所有点赞
	 * 
	 * @return
	 */
	public List<Like> queryLikeList(Like like, PageBean page) throws Exception;

	/**
	 * 保存点赞
	 * 
	 * @param like
	 * @return
	 */
	public int insertLike(Like like) throws Exception;

	/**
	 * 删除点赞
	 * 
	 * @param id
	 * @return
	 */
	public int deleteLike(int id) throws Exception;
	
	public int deleteLike(int uid, int bkid) throws Exception;

	/**
	 * 更新点赞
	 * 
	 * @param like
	 * @return
	 */
	public int updateLike(Like like) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Like queryLikeById(int id) throws Exception;
}
