package com.hp.Interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hp.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorAction extends AbstractInterceptor{
	// 把不进拦截的url放到List<String>中
	public List<String> URL_NOT_PASS = new ArrayList<String>() {{
		add("/loginDemo");
		add("/toBook");
		add("/findBook");
		add("/checkUser");
		add("/addUser");
		add("/login.html");
		add("/codeServlet");
		add("/loginms");
	}};
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String url = request.getServletPath();
		System.out.println(url);
		return invocation.invoke();
		/*if (URL_NOT_PASS.contains(url)) {
			return invocation.invoke();
		}
		User userInfo = (User) request.getSession().getAttribute("userInfo");
		if (userInfo==null) {
			request.setAttribute("msg", "请先登录");
			return "login";
		}
		return invocation.invoke();*/
	}

}
