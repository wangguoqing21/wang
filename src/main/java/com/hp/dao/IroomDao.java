package com.hp.dao;

import java.util.List;

import com.hp.entity.Log;
import com.hp.entity.Need;
import com.hp.entity.Room;

public interface IroomDao {
//	查询user实体类的方法
	public List<Room> findroom();
	/**
	 * 获取分页条件的每页数据
	 * @param page 页数
	 * @param limit 每页行数
	 * @return
	 */
    public List<Room> getlogCount(int page,int limit);
    /**
	 * 根据id查询需求情况
	 */
	public Room findRoomById(int id);
	/**
	 * 修改异常情况
	 */
	void updateRoom(Room room);
	/**
	 * 删除异常情况
	 */
	public void dropRoom(int id);
}
