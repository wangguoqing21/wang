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

@Entity
@Table(name="t_room")
public class Room {

    private int id; 
    private String roomName;//房间号
    private String remark;//房间描述
    private String image;//房间图片
    private  Room_cat room_cat;//房间分类
    private int isLive;//1 无人预订(空房) 2 已预订 3 已入住  4 故障 5 已结账
    private int floor; //楼层 1:1层 2:2层
    private int isClean;//是否需要打扫
    private int ispay; 
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="room_cat_id")
    public Room_cat getRoom_cat() {
        return room_cat;
    }
    
    public void setRoom_cat(Room_cat room_cat) {
        this.room_cat = room_cat;
    }
    
    public int getIsLive() {
        return isLive;
    }
    
    public void setIsLive(int isLive) {
        this.isLive = isLive;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public void setFloor(int floor) {
        this.floor = floor;
    }
    
    public int getIsClean() {
        return isClean;
    }
    
    public void setIsClean(int isClean) {
        this.isClean = isClean;
    }
	public int getIspay() {
		return ispay;
	}
	public void setIspay(int ispay) {
		this.ispay = ispay;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + ", remark=" + remark + ", image=" + image + ", room_cat="
				+ room_cat + ", isLive=" + isLive + ", floor=" + floor + ", isClean=" + isClean + ", ispay=" + ispay
				+ "]";
	}
    

    
    
    
}
