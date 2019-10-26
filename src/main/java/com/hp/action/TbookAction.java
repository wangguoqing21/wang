package com.hp.action;

import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.hp.entity.Book;
import com.hp.entity.User;
import com.hp.service.ItbookService;

@Controller
@Namespace("/")
public class TbookAction extends BaseAction{
	@Resource
	private ItbookService tbookService;
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
//	@Action(value="tbooklist",results= {
//			@Result(name="success",location="/fkydgl.jsp")
//	})
//	public String tbooklist() {
//
//		List<Book> list = tbookService.findtbook();
//		System.out.println(list.size());
//		getRequest().setAttribute("tbooklist", list);
//		return "success";
//		
//	}
	@Action(value="rzlist",results= {
			@Result(name="success",location="/ruzhu.jsp")
	})
	public String rzlist() {

		List<Book> list = tbookService.findtbook();
		System.out.println(list.size());
		getRequest().setAttribute("rzlist", list);
		return "success";	
	}
	@Action(value="hflist",results= {
			@Result(name="success",location="/huanf.jsp")
	})
	public String hflist() {

		List<Book> list = tbookService.hftbook();
		System.out.println(list.size());
		getRequest().setAttribute("hflist", list);
		return "success";	
	}
	@Action(value="deletetbook")
	public void deletetbook() throws IOException {
		String d = getRequest().getParameter("id");
		Integer id = Integer.parseInt(d);
		tbookService.deletetbook(id);
		getResponse().getWriter().write(JSON.toJSONString("success"));
	}
//	@Action(value="deletebook",results= {
//			@Result(name="success",type="chain",location="")
//			})
//	public String deletebook() {
//		String d = getRequest().getParameter("id");
//		Integer id = Integer.parseInt(d);
//		tbookService.deletetbook(id);
//		return "success";
//	}
	
	@Action(value="findbyid",results= {
			@Result(name="findbyid",location="/updatehf.jsp")
	})
	public String findbyid() {
		String d = getRequest().getParameter("id");
		Integer id = Integer.parseInt(d);
		Book book = tbookService.findbyid(id);
		getRequest().setAttribute("book", book);
		return "findbyid";
		
	}
	@Action(value="updaterz",results= {
			@Result(name="updaterz",location="/ruzhub.jsp")
	})
	public String updaterz() {
		String d = getRequest().getParameter("id");
		Integer id = Integer.parseInt(d);
		tbookService.updaterz(id);
		return "updaterz";
	}
	@Action(value="updatehf",results= {
			@Result(name="success",location="/huanfb.jsp")
	})
	public String updatehf() {
		tbookService.updatehf(book);
		System.out.println(book.getId()+"fkfkfkvkkvkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		return SUCCESS;
		
	}
	@Action(value="jzlist",results= {
			@Result(name="success",location="/jiezh.jsp")
	})
	public String jzlist() {

		List<Book> list = tbookService.findBook();
		System.out.println(list.size());
		getRequest().setAttribute("jzlist", list);
		return "success";	
	}
	
	
	@Action(value="tbooklist")
	public void tbooklist() throws IOException {
		List<Book> tbooklist = tbookService.findtbook();
		System.out.println(tbooklist.size());
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "");
		obj.put("count", 1000);
		obj.put("data", tbooklist);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().write(obj.toJSONString());
	}
	
	@Action(value="chackhf")
	public void chackhf() throws IOException {
		String d=getRequest().getParameter("roomName");
		List<Book> list = tbookService.chackhf(d);	 
		System.out.println(list.size()+"cccccccccccccccccccccccccccccccccccccccccccccc");
		if(list.size()!=0) {
			getResponse().getWriter().write(JSON.toJSONString("success"));
		}else {
			getResponse().getWriter().write(JSON.toJSONString("error"));
		}
	}
	

}
