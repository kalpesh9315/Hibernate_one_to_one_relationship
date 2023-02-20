<%@page import="com.dao.EmployeeDao"%>
<%@page import="com.model.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style type="text/css">
tr,td{
	padding: 10px;
}
</style>
</head>

<%-- <%if((String)request.getAttribute("msg")!=null) {%>
<h3><%= request.getAttribute("msg") %></h3><%} %> --%>
<body>

	<table width="100%" border="1" cellspacing="10px" cellpadding="10px">
	<tr>
		<td>Employee ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Email</td>
		<td>UserName</td>
		<td>Password</td>
		<td>Action</td>
		<td>Action</td>
	</tr>
	<% 
		List<EmployeeModel> employeeModels=EmployeeDao.getAllEmployees();
		for(EmployeeModel employeeModel:employeeModels){
	%>			
	<tr>
		<td><%= employeeModel.getEid() %></td>
		<td><%= employeeModel.getEpid().getFname() %></td>
		<td><%= employeeModel.getEpid().getLname() %></td>
		<td><%= employeeModel.getEpid().getEmail() %></td>
		<td><%= employeeModel.getUname() %></td>
		<td><%= employeeModel.getPassword() %></td>
		<td>
			<form method="post" action="EmployeeController">
			<input type="hidden" name="eid" value=<%=employeeModel.getEid() %>>
			<input type="submit" value="edit" name="action" class="btn btn-primary">
			</form>
		</td>
		<td>
			<form method="post" action="EmployeeController">
			<input type="hidden" name="eid" value=<%=employeeModel.getEid() %>>
			<input type="submit" value="delete" name="action" class="btn btn-danger">
			</form>
		</td>
	</tr>			
	<% 	}
	%>
	</table>
</body>
</html>