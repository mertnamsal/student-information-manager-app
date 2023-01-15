package com.mertnamsal.service;

import java.util.List;

import com.mertnamsal.dao.OgrenciDao;
import com.mertnamsal.entity.Ogrenci;

public class OgrenciService {
	
	private OgrenciDao ogrenciDao;
	

	public OgrenciService() {
		ogrenciDao = new OgrenciDao();
	}


	public List<Ogrenci> listAll() {
		return ogrenciDao.listAll();
	}


	public void create(Ogrenci ogrenci) {
		ogrenciDao.create(ogrenci);
		
	}


	public void update(long id,Ogrenci ogrenci) {
		
		ogrenciDao.update(id, ogrenci);
		
	}


	public List<Ogrenci> findByUsername(String name) {
		return ogrenciDao.findByUserName(name);
		
	}


	public List<Ogrenci> findByEmail(String email) {
		return ogrenciDao.findByEmail(email);
		
	}


	public List<Ogrenci> findByLastName(String lastName) {
		return ogrenciDao.findByLastName(lastName);
	}


	public void delete(Ogrenci ogrenci) {
		ogrenciDao.delete(ogrenci);
		
	}

}
