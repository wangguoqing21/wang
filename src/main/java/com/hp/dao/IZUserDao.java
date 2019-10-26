package com.hp.dao;

import com.hp.entity.User;

public interface IZUserDao {
	// 验证账号和密码
	public User checkUserNameAndPassword(User user);
	// 保存用户信息
	public void saveUser(User user);
	
	/**
	 * 通过用户名查询用户信息
	 */
	public User getUserByUser(User user);
	
	//添加用户信息
	public void addUser(User user);
}
