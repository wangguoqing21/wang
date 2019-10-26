package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.ItemCartDao;
import com.hp.entity.Item_cat;
import com.hp.entity.Room_cat;
import com.hp.entity.User;

@Repository
public class ItemCartDaoImpl implements ItemCartDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Item_cat> findItemCat() {
		// TODO Auto-generated method stub
		List<Item_cat> itemList = (List<Item_cat>) hibernateTemplate.find("from Item_cat");
		System.out.println(itemList);
		return itemList;
	}
/**
 * id查询
 */
	@Override
	public Item_cat fanditemByid(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Item_cat.class, id);
		
	}
/**
 * 删除
 */
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 hibernateTemplate.delete(fanditemByid(id));
	}

}
