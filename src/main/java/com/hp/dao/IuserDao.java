package com.hp.dao;

import java.util.List;

import com.hp.entity.Log;
import com.hp.entity.User;
public interface IuserDao {
//	查询user实体类的方法
	public List<User> findUser();
	/**
	 * 通过用户名查询用户信息
	 */
	public Boolean getUserByUserName(String userName);
	
	/**
	 * 通过用户名和密码查询用户信息
	 */
	public User getUserByUserNameAndPwd(String userName,String passWord);
	/**
	 * 修改异常情况
	 */
	public void updateNeed(User user);
	/**
	 * 删除异常情况
	 */
	public void dropNeed(int id);
//	id
	public User findNeedById(int id);
	/**
	 * 获取分页条件的每页数据
	 * @param page 页数
	 * @param limit 每页行数
	 * @return
	 */
    public List<User> getUserCount(int page,int limit);
}
