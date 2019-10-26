package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.IuserDao;
import com.hp.entity.User;
import com.hp.service.IuserService;
@Service
@Transactional(readOnly=false)
public class UserService implements IuserService{

	@Resource
	private IuserDao userdao;
	@Override
	public List<User> findUser() {
		// TODO Auto-generated method stub
		return userdao.findUser();
	}
	@Override
	public List stulist(int page, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long procount() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 通过用户名查询用户信息
	 */
	public Boolean getUserByUserName(String userName) {
		return userdao.getUserByUserName(userName);
		
	}
	
	/**
	 * 通过用户名和密码查询用户信息
	 */
	public User getUserByUserNameAndPwd(String userName,String passWord) {
		return userdao.getUserByUserNameAndPwd(userName, passWord);
		
	}
	@Override
	public void updateNeed(User user) {

		userdao.updateNeed(user);
	}
	@Override
	public void dropNeed(int id) {
        System.out.println(id+"....................------------------");
		userdao.dropNeed(id);
	}
	@Override
	public User findNeedById(int id) {
		// TODO Auto-generated method stub
		return userdao.findNeedById(id);
	}
	//获取分页条件的每页数据
		@Override
		public List<User> getUserCount(int page, int limit) {
			
			return userdao.getUserCount(page, limit);
		}

}
