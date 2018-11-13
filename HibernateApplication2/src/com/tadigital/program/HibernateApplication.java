package com.tadigital.program;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tadigital.entity.Customer;
import com.tadigital.hibernate.HibernateUtility;

public class HibernateApplication {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Insert
		Customer c = new Customer();
		c.setCustName("Kashif");
		c.setUsername("k");
		c.setPassword("99999");
		c.setProfilePic("image");
		
		session.save(c);
		
		//Select
		String hql = "FROM Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		for(Customer customer : list) {
			System.out.println("Name" + customer.getCustName());
			System.out.println();
		}
		
		hql = "SELECT cobj.custName FROM Customer cobj WHERE cobj.id > 0";
		query = session.createQuery(hql);
		Iterator<Object> iterator = query.iterate();
		while(iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println("Name: " + (String)object);
			System.out.println();
		}
		
		Customer customer = session.get(Customer.class, 23);
		if(customer != null) {
			System.out.println("Name: " + customer.getCustName());
			System.out.println();
		}
		else {
			System.out.println("No record Found");
			System.out.println();
		}
		
		//Update
		Customer cust = session.get(Customer.class, 23);
		if(cust != null) {
			cust.setProfilePic("test");
			cust.setCustName("Testing");
			session.update(cust);
			System.out.println("Record Updated");
		}
		else {
			System.out.println("Record upation not successful");
		}
		
		//Delete
		Customer customer2 = session.get(Customer.class, 23);
		if(customer2 != null) {
			session.delete(customer2);
			System.out.println("Record Deleted");
		}
		else {
			System.out.println("Record deletion not successful");
		}
		
		
		transaction.commit();
		session.close();
		HibernateUtility.closeSessionFactory();
	}

}
