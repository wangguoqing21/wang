package com.hp.dao;

import java.util.List;



import com.hp.entity.Book;

public interface ItbookDao {
	public List<Book> findtbook();
	public Book findbyid(Integer id);
	public void deletetbook(Integer id);
	public List<Book> hftbook();
	public void updatehf(Book book);
	public List<Book> findBook();
	public void updaterz(Integer id);
	
	public List<Book> chackhf(String roomName);
	public List<Book> getfenzhu(int page,int limit);
	public List<Book> getfenzhusy(int page,int limit);
	public List<Book> getfenzhurz(int page,int limit);
}
