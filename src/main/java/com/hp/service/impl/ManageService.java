package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.ImanageDao;
import com.hp.entity.Manage;
import com.hp.service.ImanageService;
@Service
@Transactional(readOnly=false)
public class ManageService implements ImanageService{

	@Resource
	private ImanageDao manageDao;
	@Override
	public List<Manage> findUser() {
		// TODO Auto-generated method stub
		return manageDao.findUser();
	}
	@Override
	public Manage findNeedById(int id) {
		// TODO Auto-generated method stub
		return manageDao.findNeedById(id);
	}
	@Override
	public void updateNeed(Manage Manage) {

		manageDao.updateNeed(Manage);
	}
	@Override
	public void dropNeed(int id) {

		manageDao.dropNeed(id);
	}
	@Override
	public List<Manage> getlogCount(int page, int limit) {
		// TODO Auto-generated method stub
		return manageDao.getmanageCount(page, limit);
	}

}
