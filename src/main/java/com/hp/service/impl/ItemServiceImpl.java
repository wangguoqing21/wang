package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.ItemDao;
import com.hp.dao.RoomCartDao;
import com.hp.entity.Item;
import com.hp.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Resource
	private ItemDao itemdaoimpl;
	@Override
	public List<Item> finditem() {
		// TODO Auto-generated method stub
		return itemdaoimpl.finditem();
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		itemdaoimpl.delete(id);
	}

}
