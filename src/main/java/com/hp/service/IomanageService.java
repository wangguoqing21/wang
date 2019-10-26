package com.hp.service;

import java.util.List;

import com.hp.entity.Manage;
import com.hp.entity.User;

public interface IomanageService {
	public List<Manage> loginman(Manage manage);
	public List<Manage> checkname(String name);
	public void addmanage(Manage manage);
}
