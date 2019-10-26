package com.hp.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import cn.hp.utils.MyPhoneCode;

@Controller
public class CodeAction extends BaseAction {
	
	/**
	 * ajax短信验证码
	 */
	@Action(value="codePhone")
	public void codePhone() {
		String phone = getRequest().getParameter("pe");
		int code = MyPhoneCode.getCode(phone);
		String cd = String.valueOf(code);
		getWriter().write(cd);
	}
}
