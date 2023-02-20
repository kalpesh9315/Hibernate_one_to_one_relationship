package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "employee",schema = "guest")
public class EmployeeModel {

//	@Id
//	@GenericGenerator(name = "inc",strategy = "increment")
//	@GeneratedValue(generator = "inc")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String uname;
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "epid")
	private EmployeeInfoModel epid;
}
