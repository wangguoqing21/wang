package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.ItbookDao;

import com.hp.entity.Book;
import com.hp.service.ItbookService;

@Service
@Transactional
public class TbookService implements ItbookService {
	@Resource
	private ItbookDao tbookDao;
	@Override
	public List<Book> findtbook() {
		
		return tbookDao.findtbook();
	}
	@Override
	public Book findbyid(Integer id) {
		// TODO Auto-generated method stub
		return tbookDao.findbyid(id);
	}
	@Override
	public void deletetbook(Integer id) {
		// TODO Auto-generated method stub
		tbookDao.deletetbook(id);
	}
	@Override
	public List<Book> hftbook() {
		// TODO Auto-generated method stub
		return tbookDao.hftbook();
	}
	@Override
	public void updatehf(Book book) {
		// TODO Auto-generated method stub
		tbookDao.updatehf(book);
	}
	@Override
	public List<Book> findBook() {
		// TODO Auto-generated method stub
		return tbookDao.findBook();
	}
	@Override
	public void updaterz(Integer id) {
		// TODO Auto-generated method stub
		tbookDao.updaterz(id);
	}
	@Override
	public List<Book> chackhf(String roomName) {
		// TODO Auto-generated method stub
		return tbookDao.chackhf(roomName);
	}
	@Override
	public List<Book> getfenzhu(int page, int limit) {
		// TODO Auto-generated method stub
		return tbookDao.getfenzhu(page, limit);
	}
	@Override
	public List<Book> getfenzhusy(int page, int limit) {
		// TODO Auto-generated method stub
		return tbookDao.getfenzhusy(page, limit);
	}
	@Override
	public List<Book> getfenzhurz(int page, int limit) {
		// TODO Auto-generated method stub
		return tbookDao.getfenzhurz(page, limit);
	}

}
