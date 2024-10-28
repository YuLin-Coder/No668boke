package com.mapper;

import com.model.Like;
import java.util.List;
import java.util.Map;

public interface LikeMapper {
	/**
	 * 查询所有点赞
	 * 
	 * @return
	 */
	public List<Like> query(Map<String, Object> inputParam);

	/**
	 * 查询点赞记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存点赞
	 * 
	 * @param like
	 * @return
	 */
	public int insertLike(Like like);
	

	/**
	 * 删除点赞
	 * 
	 * @param id
	 * @return
	 */
	public int deleteLike(int id);
	public int delLike(Map<String, Object> inputParam);

	/**
	 * 更新点赞
	 * 
	 * @param like
	 * @return
	 */
	public int updateLike(Like like);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Like queryLikeById(int id);
}
