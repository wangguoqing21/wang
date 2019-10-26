package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.ItemDao;
import com.hp.entity.Item;
import com.hp.entity.Room_cat;
@Repository
public class ItemDaoImpl implements ItemDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Item> finditem() {
		// TODO Auto-generated method stub
		List<Item> item = (List<Item>) hibernateTemplate.find("from Item");
		System.out.println(item);
		return item;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(getitemByid(id));
	}

	@Override
	public Item getitemByid(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Item.class, id);
	}

}
