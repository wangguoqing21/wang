package com.hp.service;

import java.util.List;

import com.hp.entity.Item;

public interface ItemService {
	public List<Item> finditem();
	public void delete(Integer id);
}
