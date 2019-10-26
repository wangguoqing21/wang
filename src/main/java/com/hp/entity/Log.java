package com.hp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="t_log")
public class Log {
	
	private int id;
	private Date createTime;//生成时间
	private Manage manageUser;//操作人
	private String content;//日志内容
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="manage_id")
    public Manage getManageUser() {
        return manageUser;
    }
    
    public void setManageUser(Manage manageUser) {
        this.manageUser = manageUser;
    }
	
	public String getContent() {
		return content;
	}
  
    public void setContent(String content) {
		this.content = content;
	}
	
    
}

