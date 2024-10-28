package com.mapper;

import com.model.Fav;
import java.util.List;
import java.util.Map;

public interface FavMapper {
	/**
	 * 查询所有关注
	 * 
	 * @return
	 */
	public List<Fav> query(Map<String, Object> inputParam);

	/**
	 * 查询关注记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存关注
	 * 
	 * @param fav
	 * @return
	 */
	public int insertFav(Fav fav);

	/**
	 * 删除关注
	 * 
	 * @param id
	 * @return
	 */
	public int deleteFav(int id);
	public int delFav(Map<String, Object> inputParam);

	/**
	 * 更新关注
	 * 
	 * @param fav
	 * @return
	 */
	public int updateFav(Fav fav);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Fav queryFavById(int id);
}
