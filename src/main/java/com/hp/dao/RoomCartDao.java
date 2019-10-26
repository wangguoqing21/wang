package com.hp.dao;

import java.util.List;

import com.hp.entity.Room_cat;



public interface  RoomCartDao{
	/**
	 * 查询全部
	 */
	public List<Room_cat> findRoomCat();
	
	/**
	 * 获取分页条件的每页数据
	 * @param page 页数
	 * @param limit 每页行数
	 * @return
	 */
    public List<Room_cat> getOrderCount(int page,int limit);
    /**
     * 根据id查询
     */
    public Room_cat getroomcartById(Integer id);
    /**
     * 删除
     */
    public void deleteroomcart(Integer id);
	/*//查询客房类型所有RoomCartDao
	public List<Room_cat> findRoomCat();
	//新增客房
	public void rommadd(Room_cat room);
	//删除客房
	public void roomdelete(Room_cat room);*/

	public void roomadd(Room_cat room);

}
