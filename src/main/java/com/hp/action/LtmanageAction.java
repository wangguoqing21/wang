package com.hp.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.hp.entity.Manage;
import com.hp.service.IomanageService;

@Controller
@Namespace("/")
public class LtmanageAction extends BaseAction{
	@Resource
	private IomanageService lomanageService;
	private Manage manage;
	public Manage getManage() {
		return manage;
	}
	public void setManage(Manage manage) {
		this.manage = manage;
	}
	@Action(value="loginms333",results= {
			@Result(name="success",location="/index.jsp"),
			@Result(name="error",location="/malogin.jsp")
	})
	public String loginm() {
		System.out.println(".................................................................");
		List<Manage> list = lomanageService.loginman(manage);

		System.out.println(list.size());
		if(list==null||list.size()==0) {
			getRequest().setAttribute("msg", "你输入的密码不正确,请重新输入");
			return "error";
		}else {
			getRequest().setAttribute("mname",manage.getName());
			return SUCCESS;	
		}		
	}
	@Action(value="loginmout",results= {
			@Result(name="success",location="/malogin.jsp")
	})
	public String loginmout() {
		getSession().invalidate();
		return SUCCESS;	
	}
	@Action(value="checkname")
	public void checkname() throws IOException {
		String name = getRequest().getParameter("name");
		List<Manage> list = lomanageService.checkname(name);
		if(list==null||list.size()==0) {
			getResponse().getWriter().write(JSON.toJSONString("success"));
		}else {
			getResponse().getWriter().write(JSON.toJSONString("error"));
		}	
	}
	@Action(value="addmanage",results= {
			@Result(name="success",location="/malogin.jsp")
			})
	public String addmanage() {
		lomanageService.addmanage(manage);
		
		return SUCCESS;
		
	}
}
