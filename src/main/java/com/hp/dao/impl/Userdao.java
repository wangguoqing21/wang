package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.IuserDao;
import com.hp.entity.Log;
import com.hp.entity.User;
@Repository
public class Userdao implements IuserDao{
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public List<User> findUser() {

		List<User> userlist=(List<User>) hibernateTemplate.find("from User");
		return userlist;
	}
	
	/**
	 * 通过用户名查询用户信息
	 */
	public Boolean getUserByUserName(String userName) {
		//查询用户是否存在
			List<User> userList = (List<User>) hibernateTemplate.find("from User where userName=?", userName);
			if (userList==null || userList.size()==0) {
				return false;
			}else {
				return true;
			}
	}
	
	
	/**
	 * 通过用户名和密码查询用户信息
	 */
	public User getUserByUserNameAndPwd(String userName,String passWord) {
		String hql="from User where userName=? and passWord=?";
		List<User> list = (List<User>) hibernateTemplate.find(hql,userName,passWord);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}

	@Override
	public void updateNeed(User user) {

		hibernateTemplate.update(user);
	}

	@Override
	public void dropNeed(int id) {
		hibernateTemplate.delete(findNeedById(id));
	}

	@Override
	public User findNeedById(int id) {

		return hibernateTemplate.get(User.class, id);
	}
	//查询分页查询
	@Override
	public List<User> getUserCount(int page, int limit) {
		Session session = sessionFactory.openSession();
        //mysql的分页条件
		int start = (page-1)*limit;
        String hql = "from User";
        Query query = session.createQuery(hql);  
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<User> user = query.list();
        session.close();

		return user; 
        
	}
	public void deleteHQL(int id) {
		this.sessionFactory.getCurrentSession()
				.createQuery("delete from user where id=?")
				.setInteger(0, id).executeUpdate();
	}


}
