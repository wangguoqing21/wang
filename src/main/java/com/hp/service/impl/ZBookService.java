package com.hp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hp.dao.IZBookDao;
import com.hp.entity.Book;
import com.hp.entity.Room;
import com.hp.service.IZBookService;
@Service
public class ZBookService implements IZBookService {
	@Autowired
	private IZBookDao bookDao;
	//查询预订房间的所有数据
	@Transactional(readOnly=true)
	public List<Book> findBook(){
		return bookDao.findBook();
	}
	//查询预订房间的所有数据
	@Transactional(readOnly=false)
	public void saveBook(Book book) {
		bookDao.saveBook(book);
	}

	// 查询所有房间信息
	@Transactional(readOnly=true)
	public List<Room> findRooms() {
		return bookDao.findRooms();
	}
	
	// 查询指定房间信息
	@Transactional(readOnly=true)
	public Room getRoomBytid(Integer tid) {
		return bookDao.getRoomBytid(tid);
	}
}
