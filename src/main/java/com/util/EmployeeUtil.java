package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.EmployeeInfoModel;
import com.model.EmployeeModel;

public class EmployeeUtil {

	public static Session createSession() {
		SessionFactory factory=new Configuration()
				.addAnnotatedClass(EmployeeInfoModel.class)
				.addAnnotatedClass(EmployeeModel.class)
				.configure()
				.buildSessionFactory();
		
		return factory.openSession(); 
		
	}
}
