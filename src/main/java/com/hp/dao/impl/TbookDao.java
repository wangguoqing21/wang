package com.hp.dao.impl;

import java.util.List;


import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BeanPropertyBindingResult;

import com.hp.dao.ItbookDao;

import com.hp.entity.Book;

@Repository
public class TbookDao implements ItbookDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Book> findtbook() {
		List<Book> tbooklist = (List<Book>) hibernateTemplate.find("from Book where status=1");
		return tbooklist;
	}

	@Override
	public Book findbyid(Integer id) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(Book.class, id);
	}

	@Override
	public void deletetbook(Integer id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(findbyid(id));
	}

	@Override
	public List<Book> hftbook() {
		List<Book> tbooklist = (List<Book>) hibernateTemplate.find("from Book where status=2");
		return tbooklist;
	}

	@Override
	public void updatehf(Book book) {
		hibernateTemplate.update(book);	
	}

	@Override
	public List<Book> findBook() {
		// TODO Auto-generated method stub
		List<Book> tbooklist = (List<Book>) hibernateTemplate.find("from Book");
		return tbooklist;
	}

	@Override
	public void updaterz(Integer id) {
		 Book book = hibernateTemplate.get(Book.class, id);
		 book.setStatus(2);
		 hibernateTemplate.update(book);
	}

	@Override
	public List<Book> chackhf(String roomName) {
		StringBuffer sb=new StringBuffer();
		sb.append(" select b.id,b.room_id from t_book b");
		sb.append("	left join t_room r on r.id=b.room_id ");
		sb.append(" left join t_user u on u.id=b.user_id "); 
		sb.append("	where r.roomName="+roomName);
		List<Book> list=jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper(Book.class));
		
		return list;
	}

	@Override
	public List<Book> getfenzhu(int page, int limit) {
		Session session = sessionFactory.openSession();
		int start = (page-1)*limit;
		String hql = "from Book where status=1";
		Query query = session.createQuery(hql);   
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<Book> list=query.list();
        session.close();
		return list;
	}

	@Override
	public List<Book> getfenzhusy(int page, int limit) {
		Session session = sessionFactory.openSession();
		int start = (page-1)*limit;
		String hql = "from Book";
		Query query = session.createQuery(hql);   
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<Book> list=query.list();
        session.close();
		return list;
	}

	@Override
	public List<Book> getfenzhurz(int page, int limit) {
		Session session = sessionFactory.openSession();
		int start = (page-1)*limit;
		String hql = "from Book where status=2";
		Query query = session.createQuery(hql);   
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<Book> list=query.list();
        session.close();
		return list;
	}

}
