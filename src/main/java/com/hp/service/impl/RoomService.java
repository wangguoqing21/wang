package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hp.dao.IroomDao;
import com.hp.dao.impl.RoomDao;
import com.hp.entity.Room;
import com.hp.service.IroomService;
@Service
@Transactional(readOnly=false)
public class RoomService implements IroomService{

	@Resource
	private  IroomDao roomdao;
	@Override
	public List<Room> findroom() {

		return roomdao.findroom();
	}
	@Override
	public List<Room> getOrderCount(int page, int limit) {
		// TODO Auto-generated method stub
		return roomdao.getlogCount(page, limit);
	}
	@Override
	public Room findRoomById(int id) {
		// TODO Auto-generated method stub
		return roomdao.findRoomById(id);
	}
	@Override
	public void updateRoom(Room room) {
		// TODO Auto-generated method stub
		roomdao.updateRoom(room);
	}
	@Override
	public void dropRoom(int id) {
		// TODO Auto-generated method stub
		roomdao.dropRoom(id);
	}
}
