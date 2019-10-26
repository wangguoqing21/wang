package com.hp.service;

import java.util.List;

import com.hp.entity.User;

public interface IuserService {
//	查询user实体类的方法
	public List<User> findUser();
    //查询学生列表
    public List stulist(int page,int limit);
    //总行数
    public long procount();
    /**
	 * 通过用户名查询用户信息
	 */
	public Boolean getUserByUserName(String userName);
	
	/**
	 * 通过用户名和密码查询用户信息
	 */
	public User getUserByUserNameAndPwd(String userName,String passWord);
	public void updateNeed(User user);
	/**
	 * 删除异常情况
	 */
	public void dropNeed(int id);
//	id
	public User findNeedById(int id);
    public List<User> getUserCount(int page,int limit);

}
