package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.model.EmployeeInfoModel;
import com.model.EmployeeModel;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("Submit")) {
			EmployeeInfoModel employeeInfoModel=new EmployeeInfoModel();
			employeeInfoModel.setFname(request.getParameter("fname"));
			employeeInfoModel.setLname(request.getParameter("lname"));
			employeeInfoModel.setEmail(request.getParameter("email"));
			EmployeeDao.insertEmployeeInfo(employeeInfoModel);
			
			EmployeeModel employeeModel=new EmployeeModel();
			employeeModel.setUname(request.getParameter("uname"));
			employeeModel.setPassword(request.getParameter("password"));
			employeeModel.setEpid(employeeInfoModel);
			EmployeeDao.insertEmployee(employeeModel);
			response.sendRedirect("view.jsp");
		}else if(action.equalsIgnoreCase("delete")) {
			int employeeId=Integer.parseInt(request.getParameter("eid"));
			EmployeeDao.deleteEmployee(employeeId);
			response.sendRedirect("view.jsp");
		}else if(action.equalsIgnoreCase("edit")) {
			int employeeId=Integer.parseInt(request.getParameter("eid"));
			EmployeeModel employeeModel= EmployeeDao.getEmployee(employeeId);
			request.setAttribute("e", employeeModel);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("update")) {
			EmployeeInfoModel employeeInfoModel=new EmployeeInfoModel();
			int employeeId=Integer.parseInt(request.getParameter("eid"));
			employeeInfoModel.setEpid(Integer.parseInt(request.getParameter("epid")));
			employeeInfoModel.setFname(request.getParameter("fname"));
			employeeInfoModel.setLname(request.getParameter("lname"));
			employeeInfoModel.setEmail(request.getParameter("email"));
			EmployeeModel employeeModel=new EmployeeModel();
			employeeModel.setEid(employeeId);
			employeeModel.setUname(request.getParameter("uname"));
			employeeModel.setPassword(request.getParameter("password"));
			employeeModel.setEpid(employeeInfoModel);
			EmployeeDao.updateEmployee(employeeModel);
			response.sendRedirect("view.jsp");
		}
	}

}
