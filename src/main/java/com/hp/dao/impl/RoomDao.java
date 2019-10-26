package com.hp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hp.dao.IroomDao;
import com.hp.entity.Log;
import com.hp.entity.Need;
import com.hp.entity.Room;
@Repository
public class RoomDao implements IroomDao{
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<com.hp.entity.Room> findroom() {
		List<Room> loglist=(List<Room>) hibernateTemplate.find("from Room");
		
		return loglist;
	}

	@Override
	public List<Room> getlogCount(int page, int limit) {
		Session session = sessionFactory.openSession();
        //mysql的分页条件
		int start = (page-1)*limit;
        String hql = "from Room";
        Query query = session.createQuery(hql);   
        query.setFirstResult((page-1)*limit);
        query.setMaxResults(limit);
        List<Room> order = query.list();
        session.close();

		return order; 
	}


	/**
	 * 客户需求管理
	 */
	public List<Room> listAllRoom(){
		List<Room> listRoom = (List<Room>) hibernateTemplate.find("from Room");
		return listRoom;
		
	}
	/**
	 * 根据id查询需求情况
	 */
	public Room findRoomById(int id) {
		List<Room> list = (List<Room>) hibernateTemplate.find("from Room where id =? ",id);
		Room room=(list!=null&&list.size()>0)? list.get(0):null;
		return room;
	}
	/**
	 * 修改
	 */
	public void updateRoom(Room room) {
		room.setImage("upload/1.jpg");
		hibernateTemplate.update(room);
	}
	/**
	 * 删除
	 */
	public void dropRoom(int id) {
		List<Room> list = (List<Room>) hibernateTemplate.find("from Room where id =? ",id);
		Room room=(list!=null&&list.size()>0)? list.get(0):null;
		hibernateTemplate.delete(room);
	}
}
