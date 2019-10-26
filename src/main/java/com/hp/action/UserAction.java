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
import com.hp.entity.Need;
import com.hp.entity.Room;
import com.hp.entity.User;
import com.hp.service.IroomService;
import com.hp.service.IuserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class UserAction extends BaseAction implements RequestAware,SessionAware, ModelDriven<User>{
	private Map<String, Object> map;
	private Map<String,Object> sMap;
	private Integer page;
	private Integer limit;
	private Room room;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
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
	private IuserService userService;
	private User user =new User();
public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public IuserService getUserService() {
		return userService;
	}
	public void setUserService(IuserService userService) {
		this.userService = userService;
	}

	//	查询用户管理的信息
	@Action(value="index",results= {
			@Result(name="success",location="/User.jsp"),
	})
    public String userindex1() {

		return SUCCESS;
    }
	@Action(value="index1")
    public void userindex() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<User> list = userService.getUserCount(page, limit);
		List<User> userlist = userService.findUser();
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg",20);
		obj.put("count", userlist.size());
		obj.put("data", list);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().write(obj.toJSONString());
    }
	@Action(value="userdelete",results= {@Result(name="success",location="/User.jsp"),})
    public String userdelete() {
		String id = getRequest().getParameter("id");
		int gid = Integer.parseInt(id);
		userService.dropNeed(gid);

		return SUCCESS;
    }
	@Action(value="userupdate",results= {@Result(name="success",location="/Updateuser.jsp"),})
    public String getbyuser() {
		String id = getRequest().getParameter("id");
		int gid = Integer.parseInt(id);
		User user = userService.findNeedById(gid);
		getRequest().setAttribute("user", user);
		return SUCCESS;
    }
	@Action(value="updateuser1",results= {
			@Result(name="success",location="/User.jsp"),
	})
    public String updateuser() {

		userService.updateNeed(user);
		return SUCCESS;
    }
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		
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
}
