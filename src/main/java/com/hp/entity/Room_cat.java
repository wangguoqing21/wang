package com.hp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_room_cat")
public class Room_cat implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id; 
	private String roomCatName;//类型名称 1代表 单人房 2 双人房
	private String upload;//首页图片
	private double price;//价格
	
	private int num;//剩余数
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
	

    
    public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
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

    
    public String getRoomCatName() {
        return roomCatName;
    }

    
    public void setRoomCatName(String roomCatName) {
        this.roomCatName = roomCatName;
    }

	@Override
	public String toString() {
		return "Room_cat [id=" + id + ", roomCatName=" + roomCatName + ", upload=" + upload + ", price=" + price
				+ ", num=" + num + "]";
	}


	
	
	}
