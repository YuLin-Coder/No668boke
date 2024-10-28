package com.service;

import java.util.List;
import com.model.Rizhi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import com.util.PageBean;
import java.util.Map;
import com.mapper.RizhiMapper;

/**
 * 日志Service实现类
 */
@Service
public class RizhiServiceImpl implements RizhiService {
	/**
	 * 注入mapper
	 */
	@Autowired
	private RizhiMapper rizhiMapper;

	/**
	 * 查询日志记录数
	 * 
	 * @param rizhi
	 * @return
	 */
	public int getCount(Rizhi rizhi) {
		Map<String, Object> map = getQueryMap(rizhi, null);
		return rizhiMapper.getCount(map);
	}

	/**
	 * 查询所有日志
	 * 
	 * @return
	 */
	public List<Rizhi> queryRizhiList(Rizhi rizhi, PageBean page)
			throws Exception {
		Map<String, Object> map = getQueryMap(rizhi, page);
		List<Rizhi> list = rizhiMapper.query(map);
		return list;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param rizhi
	 * @param page
	 * @return
	 */
	private Map<String, Object> getQueryMap(Rizhi rizhi, PageBean page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (rizhi != null) {
			map.put("id", rizhi.getId());
			map.put("uid", rizhi.getUid());
			map.put("cdate", rizhi.getCdate());
		}
		if (page != null) {
			PageBean.setPageMap(map, page);
		}
		return map;
	}

	/**
	 * 保存日志
	 * 
	 * @param rizhi
	 * @return
	 */
	public int insertRizhi(Rizhi rizhi) throws Exception {
		return rizhiMapper.insertRizhi(rizhi);
	}

	/**
	 * 删除日志
	 * 
	 * @param id
	 * @return
	 */
	public int deleteRizhi(int id) throws Exception {
		return rizhiMapper.deleteRizhi(id);
	}

	/**
	 * 更新日志
	 * 
	 * @param rizhi
	 * @return
	 */
	public int updateRizhi(Rizhi rizhi) throws Exception {
		return rizhiMapper.updateRizhi(rizhi);
	}

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Rizhi queryRizhiById(int id) throws Exception {
		return rizhiMapper.queryRizhiById(id);
	}
}
