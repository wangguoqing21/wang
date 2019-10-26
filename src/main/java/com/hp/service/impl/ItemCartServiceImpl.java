package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.ItemCartDao;

import com.hp.entity.Item_cat;
import com.hp.service.ItemCartService;

@Service
@Transactional
public class ItemCartServiceImpl implements ItemCartService {

	@Resource
	private ItemCartDao itemcartdao;
	
	@Override
	public List<Item_cat> findItemCat() {
		// TODO Auto-generated method stub
		return itemcartdao.findItemCat();
	}

	@Override
	public Item_cat fanditemByid(Integer id) {
		// TODO Auto-generated method stub
		
		return itemcartdao.fanditemByid(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		itemcartdao.delete(id);
	}

}
