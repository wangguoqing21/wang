package com.hp.dao;

import java.util.List;

import com.hp.entity.Item_cat;



public interface ItemCartDao {

	public List<Item_cat> findItemCat();
	/**
	 * 根据id
	 */
	public Item_cat fanditemByid(Integer id);
	/**
	 * 删除
	 */
	public void delete(Integer id);
}
