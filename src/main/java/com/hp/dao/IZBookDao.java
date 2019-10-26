package com.hp.dao;

import java.util.List;

import com.hp.entity.Book;
import com.hp.entity.Room;

public interface IZBookDao {
	//查询预订房间的所有数据
	public List<Book> findBook();

	// 保存用户预约信息
	public void saveBook(Book book);
	
	// 查询所有房间信息
	public List<Room> findRooms();
	
	// 查询指定房间信息
	public Room getRoomBytid(Integer tid);
}
