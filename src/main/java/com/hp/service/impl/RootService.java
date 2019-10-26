package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.IRootDao;
import com.hp.entity.Buy;
import com.hp.entity.Mistake;
import com.hp.entity.Need;
import com.hp.entity.UserRoom;
import com.hp.service.IRootService;
import com.hp.utils.Pager;
@Service

@Transactional(propagation=Propagation.REQUIRED)
public class RootService implements IRootService {
	@Resource
private IRootDao rootDao;
	/**
	 * 酒店卫生管理
	 */

	@Transactional(readOnly=true)
	public List<UserRoom> listAllUserRoom() {
		// TODO Auto-generated method stub
		return rootDao.listAllUserRoom();
	}
	/**
	 * 异常情况管理
	 */
	@Transactional(readOnly=true)
	public List<Mistake> findMistake() {
		
		return rootDao.findMistake();
		
	}
	/**
	 * 根据id查询异常情况
	 */
	@Transactional(readOnly=true)
	public Mistake findMistakeById(int id) {
		
		return rootDao.findMistakeById(id);
		
	}
	/**
	 * 修改异常情况
	 */
	public void updateMistake(Mistake mistake) {
		rootDao.updateMistake(mistake);
	}
	/**
	 * 删除异常情况
	 */
	public void dropMistake(int id) {
		rootDao.dropMistake(id);
	}

	
	
	/**
	 * 客户需求管理
	 */
	public List<Need> listAllNeed(){
		return rootDao.listAllNeed();
		
	}
	/**
	 * 根据id查询需求情况
	 */
	public Need findNeedById(int id) {
		
		return rootDao.findNeedById(id);
	}
	/**
	 * 修改异常情况
	 */
	 public void updateNeed(Need need) {
		 rootDao.updateNeed(need);
		 
	 }
	/**
	 * 删除异常情况
	 */
	public void dropNeed(int id) {
		rootDao.dropNeed(id);
	}
	/**
	 * 酒店物品采购
	 */
	public List<Buy> listBuy(){
		return rootDao.listBuy();
	}
	/**
	 * 根据id删除物品采购信息
	 */
	public void dropBuy(int id) {
		rootDao.dropBuy(id);
	}
	@Override
	public List<Mistake> getMistakeCount(int page, int limit) {
		// TODO Auto-generated method stub
		return rootDao.getMistakeCount(page, limit);
	}
}
