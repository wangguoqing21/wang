package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.ImanageDao;
import com.hp.entity.Log;
import com.hp.entity.Manage;
@Repository
public class ManageDao implements ImanageDao{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<Manage> findUser() {
		List<Manage> userlist=(List<Manage>) hibernateTemplate.find("from Manage");
		return userlist;
	}
	@Override
	public Manage findNeedById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Manage.class, id);
	}
	@Override
	public void updateNeed(Manage Manage) {

		hibernateTemplate.update(Manage);
	}
	@Override
	public void dropNeed(int id) {

		hibernateTemplate.delete(findNeedById(id));
	}
	/**
	 * 查询分页
	 */
	@Override
	public List<Manage> getmanageCount(int page, int limit) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        //mysql的分页条件
		int start = (page-1)*limit;
        String hql = "from Manage";
        Query query = session.createQuery(hql);   
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<Manage> order = query.list();
        session.close();

		return order; 
	}

}
