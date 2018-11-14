package com.tadigital.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tadigital.entity.Vendor;

@Repository
public class VendorDaoImp implements VendorDao{
	private SessionFactory sessionFactory;
	
	@Autowired
	public VendorDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public boolean loginProcess(Vendor v) {
		boolean status = false;
		Session session = sessionFactory.openSession();
		String hql = "FROM Vendor vobj WHERE vobj.uname = :user_name AND vobj.password = :pwd";
		Query query = session.createQuery(hql);
		query.setParameter("user_name", v.getUname());
		query.setParameter("pwd", v.getPassword());
		
		List<Vendor> vendors = query.list();
		if(vendors.size() == 1) {
			status = true;
		}
		session.close();
		return status;
	}
	
	public boolean registerVendor(Vendor v) {
		boolean status = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		System.out.println(session.save(v));
		
		transaction.commit();
		status = true;
		
		session.close();
		return status;
	}

	@Override
	public List<Vendor> getVendors() {
		Session session = sessionFactory.openSession();
		
		String hql = "FROM Vendor";
		Query query = session.createQuery(hql);
		
		List<Vendor> vendors = query.list();
		
		session.close();
		return vendors;
	}

	@Override
	public List<Vendor> deleteVendor(int vid) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Vendor vendor = session.get(Vendor.class, vid);
		if(vendor != null) {
			session.delete(vendor);
			
			transaction.commit();
			
			String hql = "FROM Vendor";
			
			Query query = session.createQuery(hql);
			
			List<Vendor> vendors = query.list();
			
			return vendors;
			
		}
		
		session.close();
		return null;
	}

	@Override
	public Vendor editVendor(int vid) {
		Session session = sessionFactory.openSession();
		Vendor v = session.get(Vendor.class, vid);
		
		if(v!=null) {
			return v;
		}
		
		return null;
	}

	@Override
	public boolean updateVendor(Vendor v) {
		boolean status = false;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Vendor vendor = session.get(Vendor.class, v.getId());
		if(vendor != null) {
			vendor.setName(v.getName());
			vendor.setUname(v.getUname());
			session.update(vendor);
		}
		
		transaction.commit();
		status = true;
		
		
		return status;
	}
}
