package com.tadigital.program;


import org.hibernate.SessionFactory;

import com.tadigital.hibernate.HibernateUtility;

public class HibernateApplication {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		
		HibernateUtility.closeSessionFactory();
	}

}
