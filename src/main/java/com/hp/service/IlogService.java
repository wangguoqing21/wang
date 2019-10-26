package com.hp.service;

import java.util.List;

import com.hp.entity.Log;

public interface IlogService {
//	查询日志实体类的方法
	public List<Log> findlog();
	/**
	 * 获取分页条件的每页数据
	 * @param page 页数
	 * @param limit 每页行数
	 * @return
	 */
	public List<Log> getOrderCount(int page,int limit);
	 /*根据id查询需求情况*/
	public Log findNeedById(int id);
	/**
	 * 修改异常情况
	 */
	void updateNeed(Log log);
	/**
	 * 删除异常情况
	 */
	public void dropNeed(int id);

}
