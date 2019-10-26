package com.hp.dao.impl;

import java.util.List;



import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.IlogDao;
import com.hp.entity.Log;
@Repository
public class LogDao implements IlogDao{
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Log> findlog() {
		List<Log> loglist=(List<Log>) hibernateTemplate.find("from Log");
		System.out.println(loglist);
		return loglist;
	}

	@Override
	public Log findNeedById(int id) {
		return hibernateTemplate.get(Log.class, id);
	}

	@Override
	public void updateNeed(Log log) {

		hibernateTemplate.update(log);
	}

	@Override
	public void dropNeed(int id) {	
		hibernateTemplate.delete(findNeedById(id));
	}

	/**
	 * 查询分页
	 */
	@Override
	public List<Log> getlogCount(int page, int limit) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        //mysql的分页条件
		int start = (page-1)*limit;
        String hql = "from Log";
        Query query = session.createQuery(hql);   
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<Log> order = query.list();
        session.close();

		return order; 
	}

}
