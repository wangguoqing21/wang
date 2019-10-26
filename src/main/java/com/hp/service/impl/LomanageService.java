package com.hp.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.IotmanageDao;
import com.hp.entity.Manage;
import com.hp.entity.User;
import com.hp.service.IomanageService;
@Service(value="lomanageService")
@Transactional
public class LomanageService implements IomanageService{
	@Resource
	private IotmanageDao otmanageDao;
	@Override
	public List<Manage> loginman(Manage manage) {
		
		return otmanageDao.loginman(manage);
	}
	@Override
	public List<Manage> checkname(String name) {
		// TODO Auto-generated method stub
		return otmanageDao.checkname(name);
	}
	@Override
	public void addmanage(Manage manage) {
		// TODO Auto-generated method stub
		otmanageDao.addmanage(manage);
	}

}
