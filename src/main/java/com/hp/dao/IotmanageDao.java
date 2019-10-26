package com.hp.dao;

import java.util.List;

import com.hp.entity.Manage;

public interface IotmanageDao {
	public List<Manage> loginman(Manage manage);
	public List<Manage> checkname(String name);
	public void addmanage(Manage manage);

}
