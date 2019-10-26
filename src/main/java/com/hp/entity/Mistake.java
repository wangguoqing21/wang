package com.hp.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_mistake")
public class Mistake {
    
	private int id;
	private String type;//异常类型
	private String detail;//详情描述
	private String remark;//备注
	private int isRepair;//是否修理1：未修理 2.已修理
    
	
	@Override
	public String toString() {
		return "Mistake [id=" + id + ", type=" + type + ", detail=" + detail + ", remark=" + remark + ", isRepair="
				+ isRepair + "]";
	}

	public Mistake(int id, String type, String detail, String remark, int isRepair) {
		super();
		this.id = id;
		this.type = type;
		this.detail = detail;
		this.remark = remark;
		this.isRepair = isRepair;
	}

	public Mistake() {
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

	public int getIsRepair() {
		return isRepair;
	}

	public void setIsRepair(int isRepair) {
		this.isRepair = isRepair;
	}

    
  
   
	
	
}
