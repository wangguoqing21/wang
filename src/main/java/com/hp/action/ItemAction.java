package com.hp.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Result;


import com.alibaba.fastjson.JSONObject;
import com.hp.entity.Item;
import com.hp.service.ItemService;

public class ItemAction extends BaseAction{

	Item items;
	private List<Item> item;
	public Item getItems() {
		return items;
	}
	public void setItems(Item items) {
		this.items = items;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	/**
	 * 查询商品管理
	 */
	@Resource
	private ItemService itemser;
	@Action(value="itemsqueryAll1",results= {
			@Result(name="success",location="/item.jsp")})
	//查询所有
	public String itemsqueryAll1() {
		
		
			return SUCCESS;
	
		
	}	
	@Action(value="itemsqueryAll")
	public void itemsqueryAll() {
		getResponse().setCharacterEncoding("UTF-8");
		item = itemser.finditem();
		
		
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg",20);
		obj.put("count", 100);
		obj.put("data", item);
		
		try {
			getResponse().getWriter().write(obj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除商品管理
	 */
	
	@Action(value="itemsdelete",results= {
			@Result(name = "success", location = "/itemsqueryAll",  type="redirect")})
public String itemsdelete() {
		System.out.println("items删除"+items.getId());
		itemser.delete(items.getId());
		System.out.println("items");
		return SUCCESS;
		
	}
}
