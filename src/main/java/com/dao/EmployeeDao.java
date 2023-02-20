package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.EmployeeInfoModel;
import com.model.EmployeeModel;
import com.util.EmployeeUtil;

public class EmployeeDao {

	public static void insertEmployeeInfo(EmployeeInfoModel employeeInfoModel) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction=session.beginTransaction();
		session.save(employeeInfoModel);
		transaction.commit();
		session.close();
	}
	
	public static void insertEmployee(EmployeeModel employeeModel) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction=session.beginTransaction();
		session.save(employeeModel);
		transaction.commit();
		session.close();
	}
	
	public static List<EmployeeModel> getAllEmployees(){
		Session session=EmployeeUtil.createSession();
		List<EmployeeModel> employeeModels= session.createQuery("from EmployeeModel").list();
		session.close();
		return employeeModels;
	}
	
	public static void deleteEmployee(int employeeId) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction=session.beginTransaction();
		EmployeeModel employeeModel=session.get(EmployeeModel.class, employeeId);
		session.delete(employeeModel);
		transaction.commit();
		session.close();
	}
	
	public static EmployeeModel getEmployee(int employeeId) {
		Session session=EmployeeUtil.createSession();
		EmployeeModel employeeModel=session.get(EmployeeModel.class, employeeId);
		session.close();
		return employeeModel;
	}
	
	public static void updateEmployee(EmployeeModel employeeModel) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(employeeModel);
		transaction.commit();
		session.close();
	}
}
