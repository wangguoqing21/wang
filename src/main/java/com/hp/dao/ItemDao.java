package com.hp.dao;

import java.util.List;

import com.hp.entity.Item;
import com.hp.entity.Room_cat;

public interface ItemDao {

	public List<Item> finditem();
	public Item getitemByid(Integer id);
	public void delete(Integer id);
}
