package com.hp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hp.dao.IZUserDao;
import com.hp.entity.User;
import com.hp.service.IZUserService;
@Transactional
@Service
public class ZUserService implements IZUserService {
	@Autowired
	private IZUserDao userDao;

	// 验证账号和密码
	@Transactional(readOnly=true)
	public User checkUserNameAndPassword(User user) {
		return userDao.checkUserNameAndPassword(user);
	};
	
	// 保存用户信息
	@Transactional(readOnly=false)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	/**
	 * 通过用户名查询用户信息
	 */
	public User getUserByUser(User user) {
		return userDao.getUserByUser(user);
	}
	
	//添加用户信息
	public void addUser(User user) {
		userDao.addUser(user);
			
	}
	
}
