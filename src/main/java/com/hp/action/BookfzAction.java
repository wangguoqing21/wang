package com.hp.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.entity.Book;
import com.hp.service.ItbookService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Namespace("/")
public class BookfzAction extends BaseAction implements RequestAware,SessionAware,ModelDriven<Book>{
	Book book;
	private Map<String, Object> map;
	private Map<String, Object> sMap;
	
	private Integer page;
	private Integer limit;
	
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
	private ItbookService tbookService; 
	
	@Action(value="listfz")
	public void listfz() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Book> list = tbookService.findtbook();
		List<Book> list2 = tbookService.getfenzhu(page, limit);
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "");
		obj.put("count", list.size());
		obj.put("data", list2);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(obj.toJSONString());
	}
	
	@Action(value="listfzsy")
	public void listfzsy() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Book> list = tbookService.findBook();
		List<Book> list2 = tbookService.getfenzhusy(page, limit);
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "");
		obj.put("count", list.size());
		obj.put("data", list2);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(obj.toJSONString());
	}
	
	@Action(value="listfzrz")
	public void listfzrz() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Book> list = tbookService.hftbook();
		List<Book> list2 = tbookService.getfenzhurz(page, limit);
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "");
		obj.put("count", list.size());
		obj.put("data", list2);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(obj.toJSONString());
	}

	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return null;
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
