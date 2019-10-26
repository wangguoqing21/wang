package com.hp.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hp.entity.User;
import com.hp.service.IZUserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class ZUserAction extends BaseAction implements ModelDriven<User> {
	@Autowired
	private IZUserService userService;
	
	private User user = new User();
	public User getModel() {
		return user;
	}
	
	/**
	 * 进入测试页面
	 */
	@Action(value="demo",results= {
			@Result(name="success",location="/login.html")
	})
	public String demo() {
		// 转换session数据
		String msg = (String) getSession().getAttribute("error");
		if (msg != null) {
			getRequest().setAttribute("error", msg);
			getSession().setAttribute("error", null);
		}
		System.out.println("=== 正在进入测试页面 ===");
		return SUCCESS;
	}
	
	/**
	 * 进入注册页面
	 */
	@Action(value="toSignIn",results= {
			@Result(name="success",location="/loginDemo")
	})
	public String toSignIn() {
		return SUCCESS;
	}
	
	/**
	 * 进行注册操作
	 */
	@Action(value="signIn",results= {
			@Result(name="success",location="demo",type = "redirectAction")
	})
	public String signIn() {
		// 获取当前时间
		Date date = new Date();
		// 设置时间为当前时间
		user.setCreateTime(date);
		// 利用当前时间设置idcard
		user.setIdCard((new SimpleDateFormat("yyyyMMddHHmmss")).format(date));
		// ???
		user.setIsDelete(2);
		// ???
		user.setCardType(0);
		// 设置初始积分为0
		user.setJifen(0);
		
		// 保存数据
		userService.saveUser(user);
		return SUCCESS;
	}
	
	/**
	 * 进行登录操作
	 */
	@Action(value="loginDemo",results= {
			@Result(name="login",location="/login.html"),
			@Result(name="success",location="demo",type = "redirectAction")
	})
	public String loginDemo() {
		User userInfo = userService.checkUserNameAndPassword(user);
		if (userInfo== null) {
			getRequest().setAttribute("msg", "用户名或密码错误");
			return "login";
		}
		getSession().setAttribute("userInfo", userInfo);
		return SUCCESS;
	}
	
	/**
	 * 进行登出操作
	 */
	@Action(value="loginOutDemo",results= {
			@Result(name="success",location="demo",type = "redirectAction")
	})
	public String loginOutDemo() {
		getSession().invalidate();
		return SUCCESS;
	}
	// 登录验证
	@Action(value="checkUser")
	public void checkUser() throws IOException {
		// 验证用户名
			User userInfo = userService.getUserByUser(user);
			if (userInfo==null) {
				// 将错误信息传送给前台
				getResponse().getWriter().write("账号或密码错误！");
			}else {
				// 将用户信息传到session域中
				getSession().setAttribute("userInfo", userInfo);
				// 讲成功信息返回给前台
				getResponse().getWriter().write("success");
			}
	}
	// 添加用户
	@Action(value="addUser",results= {
			@Result(name="success",location="/login.html")
	})
	public String addUser() {
		userService.addUser(user);
		System.out.println(11);
		return SUCCESS;
	}
	
	
	
}
