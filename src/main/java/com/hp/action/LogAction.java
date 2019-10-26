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
import com.hp.entity.Log;
import com.hp.entity.Room;
import com.hp.service.IlogService;
import com.hp.service.IroomService;
import com.hp.service.impl.RoomService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
public class LogAction extends BaseAction implements RequestAware,SessionAware,ModelDriven<Log>{
	@Resource
	private IlogService logService;
	private Map<String, Object> map;
	private Map<String,Object> sMap;
	private Integer page;
	private Integer limit;
	private Log log=new Log();
    public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
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
	//	查询日志管理的信息
	@Action(value="index4",results= {
			@Result(name="success",location="/Log.jsp"),
	})
    public String userindex3() {
		return SUCCESS;
    }

	 //表格信息+分页
	@Action(value="listoooo")
	public void list() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Log> list = logService.findlog();	
		List<Log> lists = logService.getOrderCount(page, limit);
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "");
		obj.put("count", list.size());
		obj.put("data", lists);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().write(obj.toJSONString());
	}
	/**
	 * 删除
	 * @return
	 */
	@Action(value="delete",results= {
	@Result(name="success",location="/Log.jsp"),
	})
    public String delete() {
		getResponse().setCharacterEncoding("UTF-8");
		String id = getRequest().getParameter("gid");
		int gid = Integer.parseInt(id);
   
		logService.dropNeed(gid);
		
		return SUCCESS;
		
    }
	@Action(value="updatelog",results= {
			@Result(name="success",location="/UpdateLog.jsp"),
	})
    public String getlogid() {
		String id = getRequest().getParameter("gid");
		int gid = Integer.parseInt(id);
		Log log = logService.findNeedById(gid);
		getRequest().setAttribute("log", log);
		return SUCCESS;
    }
	@Action(value="updatelog1",results= {
			@Result(name="success",location="/Log.jsp"),
	})
    public String update() {
		logService.updateNeed(log);
		return SUCCESS;
    }
	@Override
	public Log getModel() {
		// TODO Auto-generated method stub
		return log;
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
