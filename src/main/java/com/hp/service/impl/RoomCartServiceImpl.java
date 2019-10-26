package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hp.dao.RoomCartDao;
import com.hp.entity.Room_cat;
import com.hp.service.RoomCartService;

@Service
@Transactional
public class RoomCartServiceImpl implements RoomCartService {

	@Resource
	private RoomCartDao roomcartdao;

	//查询全部信息
		
		
	@Override
	@Transactional(readOnly=true)
	public List<Room_cat> findOrder() {
		// TODO Auto-generated method stub
		return roomcartdao.findRoomCat();
	}

	//获取分页条件的每页数据
	@Override
	public List<Room_cat> getOrderCount(int page, int limit) {
		// TODO Auto-generated method stub
		return roomcartdao.getOrderCount(page, limit);
	}

	//删除
	@Override
	public void deleteroomcart(Integer id) {
		// TODO Auto-generated method stub
		roomcartdao.deleteroomcart(id);
	}

	@Override
	public Room_cat getOrderByorderId(Integer id) {
		// TODO Auto-generated method stub
		return roomcartdao.getroomcartById(id);
		
	}

	@Override
	public void roomadd(Room_cat room) {
		// TODO Auto-generated method stub
		roomcartdao.roomadd(room);
	}


	
	
		
}
