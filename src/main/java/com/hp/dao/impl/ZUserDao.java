package com.hp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.hp.dao.IZUserDao;
import com.hp.entity.User;

@Repository
public class ZUserDao implements IZUserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	// 验证账号和密码
	public User checkUserNameAndPassword(User user) {
		//List<Tuser> users = (List<Tuser>) hibernateTemplate.find("from Tuser where userName=? and passWord=?",user.getUserName(),user.getPassWord());
		List<User> users = hibernateTemplate.findByExample(user);
		if(users==null||users.size()==0) return null;
		return users.get(0);
	}
	// 保存用户信息
	public void saveUser(User user) {
		hibernateTemplate.save(user);
	}
	/**
	 * 通过用户名查询用户信息
	 */

	/**
	 * 通过用户名查询用户信息
	 */
	public User getUserByUser(User user) {
		if (user == null)
			return null;
		if (user.getUserName() == null)
			return null;
		if (user.getPassWord() == null) 
			return null;
		
		List<User> users = (List<User>) hibernateTemplate.find("from User where userName=? and passWord=?", user.getUserName(), user.getPassWord());
		
		if (users == null || users.size() == 0)
			return null;
		System.out.println(users.get(0));
		return users.get(0);
	}
	
	//添加用户信息
	public void addUser(User user) {
		hibernateTemplate.save(user);
		
	}
	
	
	
}
