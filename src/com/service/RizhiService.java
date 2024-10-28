package com.service;

import java.util.List;
import com.util.PageBean;
import com.model.Rizhi;

/**
 * 日志Service接口
 */
public interface RizhiService {
	/**
	 * 查询日志记录数
	 * 
	 * @param rizhi
	 * @return
	 */
	public int getCount(Rizhi rizhi);

	/**
	 * 查询所有日志
	 * 
	 * @return
	 */
	public List<Rizhi> queryRizhiList(Rizhi rizhi, PageBean page)
			throws Exception;

	/**
	 * 保存日志
	 * 
	 * @param rizhi
	 * @return
	 */
	public int insertRizhi(Rizhi rizhi) throws Exception;

	/**
	 * 删除日志
	 * 
	 * @param id
	 * @return
	 */
	public int deleteRizhi(int id) throws Exception;

	/**
	 * 更新日志
	 * 
	 * @param rizhi
	 * @return
	 */
	public int updateRizhi(Rizhi rizhi) throws Exception;

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Rizhi queryRizhiById(int id) throws Exception;
}
