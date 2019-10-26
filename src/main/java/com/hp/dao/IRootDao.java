package com.hp.dao;

import java.util.List;

import com.hp.entity.Buy;
import com.hp.entity.Log;
import com.hp.entity.Mistake;
import com.hp.entity.Need;
import com.hp.entity.UserRoom;
import com.hp.utils.Pager;


public interface IRootDao {
	/**
	 * 酒店信息查询
	 */

	List<UserRoom> listAllUserRoom();
	/**
	 * 异常情况管理
	 */
	public List<Mistake> findMistake();
	/**
	 * 根据id查询异常情况
	 */
	public Mistake findMistakeById(int id);
	/**
	 * 修改异常情况
	 */
	public void updateMistake(Mistake mistake);
	/**
	 * 删除异常情况
	 */
	public void dropMistake(int id);
	
	
	/**
	 * 客户需求管理
	 */
	List<Need> listAllNeed();
	/**
	 * 根据id查询需求情况
	 */
	public Need findNeedById(int id);
	/**
	 * 修改异常情况
	 */
	void updateNeed(Need need);
	/**
	 * 删除异常情况
	 */
	public void dropNeed(int id);
	/**
	 * 酒店物品采购
	 */
	public List<Buy> listBuy();
	/**
	 * 根据id删除物品采购信息
	 */
	public void dropBuy(int id);
	/**
	 * 获取分页条件的每页数据
	 * @param page 页数
	 * @param limit 每页行数
	 * @return
	 */
    public List<Mistake> getMistakeCount(int page,int limit);
}
