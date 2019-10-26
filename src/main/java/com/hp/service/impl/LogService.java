package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.IlogDao;
import com.hp.entity.Log;
import com.hp.service.IlogService;
@Service
@Transactional(readOnly=false)
public class LogService implements IlogService{

	@Resource
	private IlogDao logDao;
	@Override
	public List<Log> findlog() {
		// TODO Auto-generated method stub
		return logDao.findlog();
	}
	@Override
	public Log findNeedById(int id) {
		// TODO Auto-generated method stub
		return logDao.findNeedById(id);
	}
	public void updateNeed(Log log) {

		logDao.updateNeed(log);
	}
	@Override
	public void dropNeed(int id) {

		logDao.dropNeed(id);
	}
	@Override
	public List<Log> getOrderCount(int page, int limit) {
		// TODO Auto-generated method stub
		return logDao.getlogCount(page, limit);
	}

}
