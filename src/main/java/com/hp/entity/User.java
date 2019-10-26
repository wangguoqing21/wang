package com.hp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_user")
public class User implements Serializable{
	private int id;
	private int sex;//1男2女
	private String userName;//用户名
	private String passWord;//密码
	private String phone;//联系电话
	private int cardType;//证件类别 0：二代身份证  1：护照 2港澳通行证 3：台湾通行证
	private String idCard;//证件号码
	private int isDelete;//是否删除；1是2不是
	private Date createTime;//创建时间
	private String email; //邮箱
	private int isVip;//是否是会员 1：是会员 2 不是
	private int jifen;//积分
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
    
    public int getIsVip() {
        return isVip;
    }
    
    public void setIsVip(int isVip) {
        this.isVip = isVip;
    }
    
    public int getCardType() {
        return cardType;
    }
    
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }
    
    public int getJifen() {
        return jifen;
    }
    
    public void setJifen(int jifen) {
        this.jifen = jifen;
    }
    
   
	
    
	
	
}
