package com.hp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();		
	}
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	public PrintWriter getWriter() {
		try {
			return getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
