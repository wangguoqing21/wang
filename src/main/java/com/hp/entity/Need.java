package com.hp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_need")
public class Need {
    
	private int id;
	private String type;//需求类型
	private String detail;//具体情况
	private String remark;//备注
    
	public Need(int id, String type, String detail, String remark) {
		super();
		this.id = id;
		this.type = type;
		this.detail = detail;
		this.remark = remark;
	}

	public Need() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
        return detail;
    }

    
    public void setDetail(String detail) {
        this.detail = detail;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   
	
	
}
