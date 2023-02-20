package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info",schema = "guest")
public class EmployeeInfoModel {
	
//	@Id
//	@GenericGenerator(name = "inc", strategy = "increment")
//	@GeneratedValue(generator = "inc")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int epid;
	
	private String fname;
	private String lname;
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "epid")
	private EmployeeModel employeeModel;
}

