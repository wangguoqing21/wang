package com.hp.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.entity.Room;
import com.hp.entity.User;
import com.hp.service.IroomService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class RoomAction extends BaseAction implements RequestAware,SessionAware, ModelDriven<Room>{
	private Map<String, Object> map;
	private Map<String,Object> sMap;
	private Integer page;
	private Integer limit;
	private Room room =new Room();
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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	@Resource
	private IroomService roomService;
	public IroomService getRoomService() {
		return roomService;
	}
	public void setRoomService(IroomService roomService) {
		this.roomService = roomService;
	}
	
	

	@Action(value="room")
    //房屋查询及分页
	public void userindex2() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Room> list = roomService.findroom();
		List<Room> list2 = roomService.getOrderCount(page, limit);
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg",20);
		obj.put("count",list.size());
		obj.put("data", list2);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().write(obj.toJSONString());
    }
	//修改房屋
	/**
	 * 根据id查询需求情况
	 */
	@Action(value = "findRoomById", results = { @Result(name = "updateRoom", location = "/roomadd.jsp") })
	public String findRoomById() {
		String nid = getRequest().getParameter("id");
		int id = Integer.parseInt(nid);
		getSession().setAttribute("id", id);
		Room room = roomService.findRoomById(id);
		getRequest().setAttribute("room", room);
		return "updateRoom";
	}
	/**
	 * 修改
	 */
	@Action(value = "updateRoom", results = { @Result(name = "find", location ="/NewFile.jsp" ) })
	public String updateNeed() {
		System.out.println(room+".....................................");
		roomService.updateRoom(room);
		return "find";
	}
	/**
	 * 删除
	 */
	@Action(value = "dropRoomById", results = { @Result(name = "findRoom", type="redirect", location = "findRoom") })
	public String dropRoomById() {
		//接收页面传来的参数
		String nid = getRequest().getParameter("id");
		int id = Integer.parseInt(nid);
		roomService.dropRoom(id);
		return "findRoom";
		
	}
	@Override
	public Room getModel() {
		// TODO Auto-generated method stub
		return room;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		
	}
}
