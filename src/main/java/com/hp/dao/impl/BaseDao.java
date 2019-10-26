package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transaction;
import javax.websocket.Session;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.action.BaseAction;
import com.hp.entity.User;
@Repository
public class BaseDao{
/*	@Resource
	private HibernateTemplate hibernateTemplate;


	public List<User> findSQLMapPage(String sql, int currPage, int pageCount) {// SQL分页
		Session session = null;
		Transaction tran = null;
		List<?> list = null;

		try {
			session = getSessionFactory().openSession();
			tran = session.beginTransaction();
			SQLQuery sqlquery = session.createSQLQuery(sql);
			sqlquery.setFirstResult((currPage - 1) * pageCount);
			sqlquery.setMaxResults(pageCount);
			sqlquery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			list = sqlquery.list();
			tran.commit();
		} catch (HibernateException e) {
			if (tran != null) {
				tran.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
 
 
 
	    //总行数
		public Long obejctCount(String hql) {
			Session session = null;
			Transaction tran = null;
			Long i = 0L;
			try {
				// 获取session
				session = getSessionFactory().openSession();
				tran = session.beginTransaction();
				Query query = session.createQuery(hql);
				i = (Long) query.uniqueResult();
				tran.commit();
			} catch (HibernateException e) {
				if (tran != null) {
					tran.rollback();
				}
				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
			return i;

		}*/

}
