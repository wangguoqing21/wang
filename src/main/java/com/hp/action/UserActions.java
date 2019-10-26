package com.hp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hp.entity.Room_cat;
import com.hp.service.RoomCartService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
//@Namespace("/sss")
public class UserActions extends ActionSupport{
	private Room_cat room=new Room_cat();
	
	 private String roomCatName;//类型名称 1代表 单人房 2 双人房
	 private double price;//价
	 private int num;
	 private File upload ; //具体上传文件的 引用 , 指向临时目录中的临时文件 
	 private String uploadFileName ; // 上传文件的名字 ,FileName 固定的写法 
	 private String file1ContentType ; 
	 @Resource
	 private RoomCartService  roomCartService;

	

	public void setRoomCartService(RoomCartService roomCartService) {
		this.roomCartService = roomCartService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}



	
	

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Room_cat getRoom() {
		return room;
	}

	public void setRoom(Room_cat room) {
		this.room = room;
	}

	public String getRoomCatName() {
		return roomCatName;
	}

	public void setRoomCatName(String roomCatName) {
		this.roomCatName = roomCatName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	@Action(value="FileUpload2",results= {
			@Result(name="success",location = "/roomcart.jsp",  type="redirect")})
	public String execute() throws Exception { 
		  //获取文件存储路径 
		ServletContext path = ServletActionContext.getServletContext();
		System.out.println(path);
		String path2 = path.getRealPath("upload");
		System.out.println(path2);
		File savefile = new File(path2, uploadFileName);
		upload.renameTo(savefile);
		room.setUpload("upload/"+uploadFileName);
		room.setRoomCatName(roomCatName);
		room.setPrice(price);
		room.setNum(num);
		roomCartService.roomadd(room);
		//room.setNum(num);
		System.out.println(room);
		  
		  return SUCCESS; 
		 }

}

	
	