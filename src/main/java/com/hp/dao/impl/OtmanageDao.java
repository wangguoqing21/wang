package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.IotmanageDao;
import com.hp.entity.Manage;

@Repository(value="otmanageDao")
public class OtmanageDao implements IotmanageDao{
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Manage> loginman(Manage manage) {
		List<Manage> list = (List<Manage>) hibernateTemplate.find("from Manage where name=? and passWord=?", manage.getName(),manage.getPassWord());
		return list;
	}

	@Override
	public List<Manage> checkname(String name) {
		List<Manage> list = (List<Manage>) hibernateTemplate.find("from Manage where name=?",name);
		return list;
	}

	@Override
	public void addmanage(Manage manage) {
		hibernateTemplate.save(manage);
		
	}

}
