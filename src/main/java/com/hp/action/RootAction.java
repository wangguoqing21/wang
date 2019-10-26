package com.hp.action;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hp.entity.Buy;
import com.hp.entity.Mistake;
import com.hp.entity.Need;
import com.hp.entity.UserRoom;
import com.hp.service.IRootService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 酒店卫生管理
 */
@Controller
public class RootAction extends BaseAction implements  RequestAware,SessionAware, ModelDriven<Mistake>{
	private Mistake mistakes=new Mistake();
	
	public Mistake getMistakes() {
		return mistakes;
	}

	public void setMistakes(Mistake mistakes) {
		this.mistakes = mistakes;
	}

	@Resource
	private IRootService rootService;
	private Map<String, Object> map;
	private Map<String,Object> sMap;
	private Integer page;
	private Integer limit;
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
	
	/**
	 * 异常情况管理
	 */
	@Action(value = "abnormal", results = { @Result(name = "obMistake", location = "/obMistake.jsp") })
	public String abnormal() {
		//List<Mistake> listMistake = rootService.findMistake();
		//getRequest().setAttribute("listMistake", listMistake);
		return "obMistake";

	}
	@Action(value = "selectAbnormal")
	public void selectAbnormal() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		//解决页面乱码
		getRequest().setCharacterEncoding("UTF-8");
		getResponse().setCharacterEncoding("UTF-8");
		List<Mistake> listMistake = rootService.findMistake();
		List<Mistake> list = rootService.getMistakeCount(page, limit);
		
		//getRequest().setAttribute("listMistake", listMistake);
		JSONObject obj = new JSONObject();
		obj.put("code", "0");
		obj.put("msg","");
		obj.put("count", listMistake.size());
		obj.put("data", list);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");  
		response.getWriter().write(obj.toJSONString());
	}
	
	/**
	 * 根据id查询异常情况
	 */
	@Action(value = "findMistakeById", results = { @Result(name = "updateMistakes", location = "/updateMistake.jsp") })
	public String findMistakeById() {
		int id = mistakes.getId();
		
		getSession().setAttribute("id", id);
		Mistake mistake=rootService.findMistakeById(id);
	
		getSession().setAttribute("mistake", mistake);
		return "updateMistakes";
	}
	
	/**
	 * 修改异常情况
	 */
	@Action(value = "updateMistake", results = { @Result(name = "abnormal", type="redirect", location = "abnormal") })
	public String updateMistake() {
		//接收页面传来的参数
		int id = mistakes.getId();
		String type = mistakes.getType();
		String detail = mistakes.getDetail();
		String remark = mistakes.getRemark();
		//把数据存进Mistake中
		Mistake mistake=new Mistake(id, type, detail, remark,0);
		
		rootService.updateMistake(mistake);
		return "abnormal";
		
	}
	/**
	 * 删除异常情况
	 */
	@Action(value = "dropMistakeById", results = { @Result(name = "abnormal", type="redirect", location = "abnormal") })
	public String dropMistakeById() {
		//接收页面传来的参数
		int id = mistakes.getId();
		rootService.dropMistake(id);
		
		return "abnormal";
		
	}
	
	
	
	/**
	 * 客户需求查询
	 */
	@Action(value = "findNeed", results = { @Result(name = "needMg", location = "/needMg.jsp") })
	public String findNeed() {
	//List<Need> listAllNeed = rootService.listAllNeed();
	//getRequest().setAttribute("listAllNeed", listAllNeed);
		return "needMg";
		
	}
	@Action(value="toFindNeed")
	public void toFindNeed() throws IOException {
		//解决乱码
		getResponse().setCharacterEncoding("UTF-8");
		List<Need> listAllNeed = rootService.listAllNeed();
		JSONObject obj = new JSONObject();
		obj.put("code", "0");
		obj.put("msg","");
		obj.put("count", 5);
		obj.put("data", listAllNeed);
		getResponse().getWriter().write(obj.toString());
	}
	
	/**
	 * 根据id查询需求情况
	 */
	@Action(value = "findNeedById", results = { @Result(name = "updateNeed", location = "/updateNeed.jsp") })
	public String findNeedById() {
		String nid = getRequest().getParameter("id");
		int id = Integer.parseInt(nid);
		getSession().setAttribute("id", id);
		Need neet = rootService.findNeedById(id);
		getRequest().setAttribute("neet", neet);
		return "updateNeed";
		
	}
	/**
	 * 修改异常情况
	 */
	@Action(value = "updateNeed", results = { @Result(name = "findNeed", type="redirect", location = "findNeed") })
	public String updateNeed() {
		//接收页面传来的参数
		String nid = getRequest().getParameter("id");
		int id = Integer.parseInt(nid);
		String type = getRequest().getParameter("type");
		String detail = getRequest().getParameter("detail");
		String remark = getRequest().getParameter("remark");	
		//把数据存进Need中
		Need need=new Need(id, type, detail, remark);
		rootService.updateNeed(need);
		return "findNeed";
		
	}
	/**
	 * 删除异常情况
	 */
	@Action(value = "dropNeedById", results = { @Result(name = "findNeed", type="redirect", location = "findNeed") })
	public String dropNeedById() {
		//接收页面传来的参数
		String nid = getRequest().getParameter("id");
		int id = Integer.parseInt(nid);
		rootService.dropNeed(id);
		return "findNeed";
		
	}
	
	/**
	 * 酒店物品采购
	 */
	@Action(value = "findBuy", results = { @Result(name = "listBuy", location = "/listBuy.jsp") })
	public String findBuy() {
		
		return "listBuy";	
	}
	@Action(value="toFindBuy")
	public void toFindBuy() throws IOException {
		//解决乱码
		getResponse().setCharacterEncoding("UTF-8");
		List<Buy> buys=rootService.listBuy();
		JSONObject obj = new JSONObject();
		obj.put("code", "0");
		obj.put("msg","");
		obj.put("count", 6);
		obj.put("data", buys);
		getResponse().getWriter().write(obj.toString());
	}
	
/**
 * 根据id删除物品采购信息
 */
	@Action(value = "dropBuyById", results = { @Result(name = "findBuy", type="redirect", location = "findBuy") })
public String dropBuyById() {
		//接收页面提交参数
		String nid = getRequest().getParameter("id");
		int id = Integer.parseInt(nid);
		rootService.dropBuy(id);
	return "findBuy";
	
}	
	
	
	@Override
	public Mistake getModel() {
		// TODO Auto-generated method stub
		return mistakes;
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
