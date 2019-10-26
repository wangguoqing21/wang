package com.hp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hp.dao.SuggestDao;
import com.hp.entity.Suggest;

@Service
@Transactional
public class SuggestService implements com.hp.service.SuggestService {
	@Resource
	private SuggestDao suggestdao;
	
	@Override
	public List<Suggest> findsuggest() {
		// TODO Auto-generated method stub
		return suggestdao.findsuggest();
	}

}
