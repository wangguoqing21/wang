package com.hp.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.hp.entity.Book;
import com.hp.entity.Room;
import com.hp.entity.User;
import com.hp.service.IZBookService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class ZBookAction extends BaseAction implements ModelDriven<Book> {
	@Autowired
	private IZBookService bookService;
	
	private Book book=new Book();
	
	public Book getModel() {
		return book;
	}
	
	/**
	 * 查询所有预约信息
	 */
	@Action(value="findBook",results= {
			@Result(name="success",location="/login2.jsp")
	})
	public String findBook() {
		List<Book> findBook = bookService.findBook();
		getRequest().setAttribute("findBook", findBook);
		System.out.println(findBook);
		return SUCCESS;
	}
	
	/**
	 * 进入用户预约页面
	 */
	@Action(value="toBook",results= {
			@Result(name="success",location="/single.jsp")
	})
	public String toBook() {
		List<Room> rooms = bookService.findRooms();
		getRequest().setAttribute("rooms",rooms);
		// 获取当前日期，传给前台
		getRequest().setAttribute("date",(new SimpleDateFormat("yyyy-MM-dd")).format((new Date())));
		return SUCCESS;
	}

	/**
	 * 进行用户预约操作
	 */
	@Action(value="book",results= {
			@Result(name="success",location="demo",type = "redirectAction")
	})
	public String book() {
		// 获取用户信息
		User userInfo = (User) getSession().getAttribute("userInfo");
		if (userInfo==null || userInfo.getId()==0) {
			getSession().setAttribute("error", "预约失败，未获取到用户信息");
			return SUCCESS;
		}
		// 设置用户信息
		book.setBookUser(userInfo);
		// 获取房间信息
		String tid = getRequest().getParameter("tid");
		Room room = bookService.getRoomBytid(tid==null?null:Integer.parseInt(tid));
		if (room==null) {
			getSession().setAttribute("error", "预约失败，未获取到房间信息");
			return SUCCESS;
		}
		// 设置房间信息
		book.setRoom(room);
		// 获取当前时间
		Date date = new Date();
		// 将当前时间设置为预约时间
		book.setBookTime(date);
		// 获取用户填写的入住天数
		String bookDays = getRequest().getParameter("bookDays");
		// 设置离开时间，从到达时间开始
		book.setLeaveTime(addDayForDate(book.getReachTime(), bookDays==null?null:Integer.parseInt(bookDays)));
		// 设置房号，通过外键中的room里提供的房间号获取
		book.setRoomNumber(room.getRoomName()==null?null:Integer.parseInt(room.getRoomName()));
		// 设置状态？？？
		book.setStatus(2);
		bookService.saveBook(book);
		return SUCCESS;
	}
	
	/**
	 * 对日期数据进行叠加
	 */
	public Date addDayForDate(Date date,Integer day) {
		// 防止出现空指针
		if (date == null || day==null) return null;
		// 进行天数的增加
		Calendar c = Calendar.getInstance();		
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}
}
