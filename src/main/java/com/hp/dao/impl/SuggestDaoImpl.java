package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.SuggestDao;
import com.hp.entity.Room_cat;
import com.hp.entity.Suggest;
@Repository
public class SuggestDaoImpl implements SuggestDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public List<Suggest> findsuggest() {
		// TODO Auto-generated method stub
		List<Suggest> sugList = (List<Suggest>) hibernateTemplate.find("from Suggest");
		System.out.println(sugList);
		return sugList;
	}

}
