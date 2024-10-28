package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Fav;

/**
 * 关注Service接口
 */
public interface FavService {
	/**
	 * 查询关注记录数
	 * 
	 * @param fav
	 * @return
	 */
	public int getCount(Fav fav);

	/**
	 * 查询所有关注
	 * 
	 * @return
	 */
	public List<Fav> queryFavList(Fav fav, PageBean page) throws Exception;

	/**
	 * 保存关注
	 * 
	 * @param fav
	 * @return
	 */
	public int insertFav(Fav fav) throws Exception;

	/**
	 * 删除关注
	 * 
	 * @param id
	 * @return
	 */
	public int deleteFav(int id) throws Exception;
	
	
	public int deleteFav(int uid, int bzid) throws Exception;

	/**
	 * 更新关注
	 * 
	 * @param fav
	 * @return
	 */
	public int updateFav(Fav fav) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Fav queryFavById(int id) throws Exception;
}
