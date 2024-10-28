package com.mapper;

import com.model.Rizhi;
import java.util.List;
import java.util.Map;

public interface RizhiMapper {
	/**
	 * 查询所有日志
	 * 
	 * @return
	 */
	public List<Rizhi> query(Map<String, Object> inputParam);

	/**
	 * 查询日志记录数
	 * 
	 * @param inputParam
	 * @return
	 */
	public int getCount(Map<String, Object> inputParam);

	/**
	 * 保存日志
	 * 
	 * @param rizhi
	 * @return
	 */
	public int insertRizhi(Rizhi rizhi);

	/**
	 * 删除日志
	 * 
	 * @param id
	 * @return
	 */
	public int deleteRizhi(int id);

	/**
	 * 更新日志
	 * 
	 * @param rizhi
	 * @return
	 */
	public int updateRizhi(Rizhi rizhi);

	/**
	 * 根据ID查询记录
	 * 
	 * @param id
	 * @return
	 */
	public Rizhi queryRizhiById(int id);
}
