package com.hp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.hp.dao.IZBookDao;
import com.hp.entity.Book;
import com.hp.entity.Room;
@Repository
public class ZBookDao implements IZBookDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//查询预订房间的所有数据
	public List<Book> findBook(){
		return (List<Book>) hibernateTemplate.find("from Book");
	}

	// 保存用户预约信息
	public void saveBook(Book book) {
		hibernateTemplate.save(book);
	}

	// 查询所有房间信息
	public List<Room> findRooms() {
		return (List<Room>) hibernateTemplate.find("from Room");
	}
	
	// 查询指定房间信息
	public Room getRoomBytid(Integer tid) {
		return hibernateTemplate.get(Room.class, tid);
	}
}
