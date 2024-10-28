package com.service;

import java.util.List;
import com.model.Fav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.FavMapper;

/**
 * 关注Service实现类
 */
@Service
public class FavServiceImpl implements FavService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private FavMapper favMapper;

	/**
	 * 查询关注记录数
	 * 
	 * @param fav
	 * @return
	 */
	public int getCount(Fav fav) {
		Map<String, Object> map = getQueryMap(fav, null);
		return favMapper.getCount(map);
	}

	/**
	 * 查询所有关注
	 * 
	 * @return
	 */
	public List<Fav> queryFavList(Fav fav, PageBean page) throws Exception {
		Map<String, Object> map = getQueryMap(fav, page);
		List<Fav> list = favMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param fav
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Fav fav, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (fav != null) {
			map.put("id", fav.getId());
			map.put("uid", fav.getUid());
			map.put("bzid", fav.getBzid());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存关注
	 * 
	 * @param fav
	 * @return
	 */
	public int insertFav(Fav fav) throws Exception {
		return favMapper.insertFav(fav);
	}

	/**
	 * 删除关注
	 * 
	 * @param id
	 * @return
	 */
	public int deleteFav(int id) throws Exception {
		return favMapper.deleteFav(id);
	}

	/**
	 * 更新关注
	 * 
	 * @param fav
	 * @return
	 */
	public int updateFav(Fav fav) throws Exception {
		return favMapper.updateFav(fav);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Fav queryFavById(int id) throws Exception {
		return favMapper.queryFavById(id);
	}
	
	
	@Override
	public int deleteFav(int uid, int bzid) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("uid", uid);
		map.put("bzid", bzid);
		return favMapper.delFav(map);
	}
}
