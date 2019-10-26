package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.RoomCartDao;
import com.hp.entity.Room_cat;
import com.hp.entity.User;
@Repository
public class RoomCartDaoImpl implements RoomCartDao {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private HibernateTemplate hibernateTemplate;

	//查询全部信息
	@Override
	public List<Room_cat> findRoomCat() {
		// TODO Auto-generated method stub
		List<Room_cat> list = (List<Room_cat>) hibernateTemplate.find("from Room_cat");
		
		return list;
	}

	//查询分页查询
	@Override
	public List<Room_cat> getOrderCount(int page, int limit) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        //mysql的分页条件
		int start = (page-1)*limit;
        String hql = "from Room_cat";
        Query query = session.createQuery(hql);   
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<Room_cat> order = query.list();
        session.close();
        
		return order; 
	}
	/**
	 * 根据id查询
	 */
	@Override
	public Room_cat getroomcartById(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Room_cat.class, id);
		 
	}
	/**
	 * 删除
	 */
	@Override
	public void deleteroomcart(Integer id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(getroomcartById(id));
		
	}

	@Override
	public void roomadd(Room_cat room) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(room);
	}


	

}
