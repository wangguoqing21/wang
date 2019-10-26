package com.hp.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Result;


import com.alibaba.fastjson.JSONObject;
import com.hp.entity.Item_cat;
import com.hp.service.ItemCartService;

public class ItemCartAction extends BaseAction{

	Item_cat it;
	private List<Item_cat> itemList ;
	
	
	
		public Item_cat getIt() {
		return it;
	}
	public void setIt(Item_cat it) {
		this.it = it;
	}
	public List<Item_cat> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item_cat> itemList) {
		this.itemList = itemList;
	}
	//查询商品类别
		@Resource
		private ItemCartService itemservice;
		
		
		
		@Action(value="itemqueryAll1",results= {
				@Result(name="success",location="/itemcart.jsp")})
		//查询所有
		public String itemqueryAll1() {
			
			
			return SUCCESS;
			
		}
		@Action(value="itemqueryAll")
		public void itemqueryAll() {
			getResponse().setCharacterEncoding("UTF-8");
			itemList = itemservice.findItemCat();
			JSONObject obj = new JSONObject();
			obj.put("code", 0);
			obj.put("msg",20);
			obj.put("count", 100);
			obj.put("data", itemList);
			
			try {
				getResponse().getWriter().write(obj.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/**
		 * 根据id查询商品类别
		 */
		
		@Action(value="itemqueryOne",results= {
				@Result(name="success",location="/itemcartQueryOne.jsp"),
				@Result(name="error",location="/error.jsp")})
	public String itemqueryOne() {
			it=itemservice.fanditemByid(it.getCid());
			System.out.println("it"+it);
			return SUCCESS;
			
		}
		/**
		 * 删除商品类别
		 */
		
		@Action(value="itemdelete",results= {
				@Result(name = "success", location = "/itemqueryAll",  type="redirect")})
	public String itemdelete() {
			System.out.println("删除"+it.getCid());
			itemservice.delete(it.getCid());
			System.out.println("it"+it);
			return SUCCESS;
			
		}
}
