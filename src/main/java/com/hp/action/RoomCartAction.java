package com.hp.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hp.entity.Item;
import com.hp.entity.Item_cat;
import com.hp.entity.Room_cat;
import com.hp.entity.Suggest;

import com.hp.service.ItemCartService;
import com.hp.service.ItemService;
import com.hp.service.RoomCartService;
import com.hp.service.SuggestService;
import com.opensymphony.xwork2.ModelDriven;



@Controller
@Namespace("/")
public class RoomCartAction extends BaseAction implements RequestAware,SessionAware,ModelDriven<Room_cat>{
	Room_cat room;
	private Map<String, Object> map;
	private Map<String,Object> sMap;
	
	private Integer page;
	private Integer limit;
	
	
    
	

	

	public Room_cat getRoom() {
		return room;
	}
	public void setRoom(Room_cat room) {
		this.room = room;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Map<String, Object> getsMap() {
		return sMap;
	}
	public void setsMap(Map<String, Object> sMap) {
		this.sMap = sMap;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	@Resource
	private RoomCartService roomservice;
	
	@Action(value="queryAll1",results= {
			@Result(name="success",location="/roomcart.jsp")})
	public String queryAll1() {
		
		return SUCCESS;
	}
	
	//表格信息+分页
		@Action(value="list")
		public void list() throws IOException {
			HttpServletResponse response = ServletActionContext.getResponse();
			
			List<Room_cat> list = roomservice.findOrder();
			
			List<Room_cat> lists = roomservice.getOrderCount(page, limit);
			JSONObject obj = new JSONObject();
			obj.put("code", 0);
			obj.put("msg", "");
			obj.put("count", list.size());
			obj.put("data", lists);
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			response.getWriter().write(obj.toJSONString());
		}
	
		
		//删除信息
		@Action(value="roomdelete",results= {
				@Result(name = "success", location = "/queryAll1",  type="redirect")})
		public String roomdelete()  {
			System.out.println("delete"+room.getId());
			roomservice.deleteroomcart(room.getId());
			return SUCCESS;
		}
		/**
		 * 添加
		 */
		
		
	@Override
	public Room_cat getModel() {
		// TODO Auto-generated method stub
		return room;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.sMap = session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.map = request;
	}
	

}
