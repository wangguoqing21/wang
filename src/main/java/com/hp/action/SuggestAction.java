package com.hp.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSONObject;
import com.hp.entity.Suggest;
import com.hp.service.SuggestService;

public class SuggestAction extends BaseAction{

	Suggest sug;
	 private List<Suggest>   sugList;
	public Suggest getSug() {
		return sug;
	}
	public void setSug(Suggest sug) {
		this.sug = sug;
	}
	public List<Suggest> getSugList() {
		return sugList;
	}
	public void setSugList(List<Suggest> sugList) {
		this.sugList = sugList;
	}
	/**
	 * 建议管理
	 */
	@Resource
	private SuggestService suggestservice;
	@Action(value="sugqueryAll1",results= {
			@Result(name="success",location="/suggeest.jsp")})
	//查询所有
	public String sugqueryAll1() {
		
	return SUCCESS;
		
	}	
	@Action(value="sugqueryAll")
	public void sugqueryAll() {
		
		getResponse().setCharacterEncoding("UTF-8");
		sugList = suggestservice.findsuggest();
		System.out.println(sugList.get(1));
		
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg",20);
		obj.put("count", 100);
		obj.put("data", sugList);
		
		try {
			getResponse().getWriter().write(obj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
