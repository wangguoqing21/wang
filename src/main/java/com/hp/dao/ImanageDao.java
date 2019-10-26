package com.hp.dao;

import java.util.List;
import com.hp.entity.Manage;
public interface ImanageDao {

//	查询manage实体类的方法
	public List<Manage> findUser();
	 /*根据id查询需求情况*/
	public Manage findNeedById(int id);
	/**
	 * 修改异常情况
	 */
	public void updateNeed(Manage Manage);
	/**
	 * 删除异常情况
	 */
	public void dropNeed(int id);
	/**
	 * 获取分页条件的每页数据
	 * @param page 页数
	 * @param limit 每页行数
	 * @return
	 */
    public List<Manage> getmanageCount(int page,int limit);
}
