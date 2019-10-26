package com.hp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="t_item")
public class Item {

	private int id;
	private String remark;//备注
	private String image;//商品图片
	private String itemName;//商品名字
	private Item_cat item_cat; //商品类别外键
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@ManyToOne
	@JoinColumn(name="cid")
	public Item_cat getItem_cat() {
		return item_cat;
	}
	public void setItem_cat(Item_cat item_cat) {
		this.item_cat = item_cat;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
    
	
	
}
