package com.hp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="t_buy")
public class Buy {
    
	private int id;
	private String name;//物品名称
	private double price;//物品价格
	private int num;//物品数量
	private String remark;//备注
     
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

    
    public double getPrice() {
        return price;
    }

    
    public void setPrice(double price) {
        this.price = price;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    
    public int getNum() {
        return num;
    }

    
    public void setNum(int num) {
        this.num = num;
    }
  
	
	
}
