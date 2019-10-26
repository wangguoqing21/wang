package com.hp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_manage")
public class Manage {
	private int id;
	private int sex;//1男2女
	private String name; //用户名
	private String passWord;//密码
	private String phone;//联系电话
    private String idCard;//证件号码
    private int isDelete;//是否删除；1是2不是
	private int type;//管理员类型 0：普通管理员 1：超级管理员
	private String email;//邮箱
	private Date createTime; //创建时间
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
    
    public int getSex() {
        return sex;
    }
    
    public void setSex(int sex) {
        this.sex = sex;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public int getIsDelete() {
        return isDelete;
    }
    
    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public String getIdCard() {
        return idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manage(int id, int sex, String name, String passWord, String phone, String idCard, int isDelete, int type,
			String email, Date createTime) {
		super();
		this.id = id;
		this.sex = sex;
		this.name = name;
		this.passWord = passWord;
		this.phone = phone;
		this.idCard = idCard;
		this.isDelete = isDelete;
		this.type = type;
		this.email = email;
		this.createTime = createTime;
	}
    
    
    
}
