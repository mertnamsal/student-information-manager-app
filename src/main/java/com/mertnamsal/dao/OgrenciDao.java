package com.mertnamsal.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mertnamsal.entity.Ogrenci;

public class OgrenciDao implements ICrud<Ogrenci> {

	@Override
	public void create(Ogrenci ogrenci) {
		Transaction transaction =null;
		try(Session session = dataBaseConnectionHibernate()){
			transaction = session.beginTransaction();
			session.save(ogrenci);
			transaction.commit();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Saved Error...");
		}
		
	}

	@Override
	public void delete(Ogrenci ogrenci) {
		Transaction transaction = null;
		try(Session session = dataBaseConnectionHibernate()){
			transaction = session.beginTransaction();
			session.delete(ogrenci);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Delete error...");
		}
		
	}

	@Override
	public void update(long id, Ogrenci ogrenci) {
		Transaction transaction =null;
		try(Session session = dataBaseConnectionHibernate()){
			transaction = session.beginTransaction();
			ogrenci.setId(id);
			session.update(ogrenci);
			transaction.commit();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Update Error...");
		}
		
	}

	@Override
	public List<Ogrenci> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select ogrenci from Ogrenci as ogrenci";
		TypedQuery<Ogrenci> typedQuery = session.createQuery(query, Ogrenci.class);
		List<Ogrenci> studentList = typedQuery.getResultList();
		return studentList;
	}

	@Override
	public Ogrenci find(long id) {
		Session session = dataBaseConnectionHibernate();
		Ogrenci ogrenci;
		try {
			ogrenci = session.find(Ogrenci.class, id);
			if (ogrenci != null) {
				System.out.println("Student Found--> " + ogrenci);
				return ogrenci;
			} else {
				System.out.println("Ogrenci yok");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Find da error");
		} finally {
			session.close();
		}
		return null;
	}
	
	public List<Ogrenci> findByUserName(String ad) {
		Session session = dataBaseConnectionHibernate();
		List<Ogrenci> ogrenci = null;
		String hql = "select ogrenci from Ogrenci as ogrenci where ogrenci.ad like :key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", ad+"%");
		try {
			ogrenci = query.getResultList();
			return ogrenci;
		} catch (Exception e) {
			System.out.println("Hata");
		}
		return ogrenci;
	}

	public List<Ogrenci> findByEmail(String email) {
		Session session = dataBaseConnectionHibernate();
		List<Ogrenci> ogrenci = null;
		String hql = "select ogrenci from Ogrenci as ogrenci where ogrenci.email like :key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", email+"%");
		try {
			
			ogrenci = query.getResultList();
			return ogrenci;
		} catch (Exception e) {
			System.out.println("Hata");

		}
		return ogrenci;
		
	}

	public List<Ogrenci> findByLastName(String lastName) {
		Session session = dataBaseConnectionHibernate();
		List<Ogrenci> ogrenci = null;
		String hql = "select ogrenci from Ogrenci as ogrenci where ogrenci.soyad like :key";
		Query query = session.createQuery(hql);
		query.setParameter("key", lastName+"%");
		try {
			ogrenci = query.getResultList();
			return ogrenci;
		} catch (Exception e) {
			System.out.println("Hata");

		}
		return ogrenci;
	}

}
