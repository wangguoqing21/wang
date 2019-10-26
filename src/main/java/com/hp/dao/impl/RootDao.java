package com.hp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.IRootDao;
import com.hp.entity.Buy;
import com.hp.entity.Log;
import com.hp.entity.Mistake;
import com.hp.entity.Need;
import com.hp.entity.UserRoom;
import com.hp.utils.Pager;

@Repository
public class RootDao implements IRootDao{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 酒店信息查询
	 */
	public List<UserRoom> listAllUserRoom(){
		 String hql = "from UserRoom where 1=1";
		 List<UserRoom> list = (List<UserRoom>) hibernateTemplate.find(hql);
		
	        return list;
		
		
	}
	/**
	 * 异常情况管理
	 */
	public List<Mistake> findMistake() {
		List<Mistake> list = (List<Mistake>) hibernateTemplate.find("from Mistake");
		return list;
		
	}
	/**
	 * 根据id查询异常情况
	 */
	public Mistake findMistakeById(int id) {
		List<Mistake> list = (List<Mistake>) hibernateTemplate.find("from Mistake where id =? ",id);
		Mistake mistake=(list!=null&&list.size()>0)? list.get(0):null;
		return mistake;
		
	}
	/**
	 * 修改异常情况
	 */
	public void updateMistake(Mistake mistake) {
		
		hibernateTemplate.update(mistake);
	}
	/**
	 * 删除异常情况
	 */
	public void dropMistake(int id) {
		List<Mistake> list = (List<Mistake>) hibernateTemplate.find("from Mistake where id =? ",id);
		Mistake mistake=(list!=null&&list.size()>0)? list.get(0):null;
		hibernateTemplate.delete(mistake);
	}
	
	
	
	/**
	 * 客户需求管理
	 */
	public List<Need> listAllNeed(){
		List<Need> listNeed = (List<Need>) hibernateTemplate.find("from Need");
		return listNeed;
		
	}
	/**
	 * 根据id查询需求情况
	 */
	public Need findNeedById(int id) {
		List<Need> list = (List<Need>) hibernateTemplate.find("from Need where id =? ",id);
		Need need=(list!=null&&list.size()>0)? list.get(0):null;
		return need;
		
	}
	/**
	 * 修改异常情况
	 */
	public void updateNeed(Need need) {
		hibernateTemplate.update(need);
	}
	/**
	 * 删除异常情况
	 */
	public void dropNeed(int id) {
		List<Need> list = (List<Need>) hibernateTemplate.find("from Need where id =? ",id);
		Need need=(list!=null&&list.size()>0)? list.get(0):null;
		hibernateTemplate.delete(need);
	}
	
	/**
	 * 酒店物品采购
	 */
	public List<Buy> listBuy(){
		List<Buy> list = (List<Buy>) hibernateTemplate.find("from Buy");
		return list;
	}
	/**
	 * 根据id删除物品采购信息
	 */
	public void dropBuy(int id) {
	List<Buy> list = (List<Buy>) hibernateTemplate.find("from Buy where id=?", id);
	Buy buy=(list!=null&&list.size()>0)? list.get(0):null;
	hibernateTemplate.delete(buy);
	}
	@Override
	public List<Mistake> getMistakeCount(int page, int limit) {
				Session session = sessionFactory.openSession();
		        //mysql的分页条件
				int start = (page-1)*limit;
		        String hql = "from Mistake";
		        Query query = session.createQuery(hql);   
		        query.setFirstResult((page-1)*limit);
		        query.setMaxResults(limit);
		        List<Mistake> order = query.list();
		        session.close();

				return order; 
	}
}
