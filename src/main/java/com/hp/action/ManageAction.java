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
import com.hp.entity.Manage;
import com.hp.service.ImanageService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class ManageAction extends BaseAction implements RequestAware,SessionAware, ModelDriven<Manage>{

	@Resource
	private ImanageService manageService;
	private Map<String, Object> map;
	private Map<String,Object> sMap;
	private Integer page;
	private Integer limit;
	private Manage manage=new Manage();
//	查询酒店人员权限的信息
	@Action(value="index3",results= {
			@Result(name="success",location="/Manage.jsp"),
	})
    public String userindex2() {

		return SUCCESS;
    }
	@Action(value="index2")
    public void manageindex() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Manage> userlist =manageService.findUser();
		List<Manage> list = manageService.getlogCount(page, limit);
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg",20);
		obj.put("count", userlist.size());
		obj.put("data", list);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().write(obj.toJSONString());
    }
	@Action(value="dropmanage",results= {
			@Result(name="success",location="/Manage.jsp"),
	})
    public String userdelete() {
		String id = getRequest().getParameter("id");
		int gid = Integer.parseInt(id);
		manageService.dropNeed(gid);

		return SUCCESS;
    }
	@Action(value="updatemarage",results= {
			@Result(name="success",location="/Updatemarage.jsp"),
	})
    public String getbymarage() {

		String id = getRequest().getParameter("id");
		int gid = Integer.parseInt(id);
		Manage marage = manageService.findNeedById(gid);
		getRequest().setAttribute("marage", marage);
		return SUCCESS;
    }
	@Action(value="updatemarage1",results= {
			@Result(name="success",location="/Manage.jsp"),
	})
    public String updatemanage() {
		manageService.updateNeed(manage);
		return SUCCESS;
    }
	@Override
	public Manage getModel() {
		// TODO Auto-generated method stub
		return manage;
	}
	public Manage getManage() {
		return manage;
	}
	public void setManage(Manage manage) {
		this.manage = manage;
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
	

}
