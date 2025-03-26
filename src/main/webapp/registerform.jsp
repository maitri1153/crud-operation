<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="InsertServlet" method="post">
			<h1>Registration Form</h1>
			
			<div class="form-group">
			<label>ID </label>
			<input type="text" name="id" class="form-control">
			</div>
			
			<div class="form-group">
			<label>Full Name </label>
			<input type="text" name="fname" class="form-control">
			</div>
			
			<div class="form-group">
			<label>E-mail</label>
			<input type="email" name="email" class="form-control"> 
			</div>
			
			<div class="form-group">
			<label>Select Gender</label><br>
			<input type="radio" id="gender" name="gender" value="female"> 
			<label class="form-check-label" for="flexRadioDefault1">Female</label><br>
			
			<input type="radio" id="gender" name="gender" value="male"> 
			<label class="form-check-label" for="flexRadioDefault1">Male</label>
			</div>
			
			<div class="form-group">
			<label> Select Date of Birth </label>
			<input type="date" name="dob" class="form-control"> 
			</div>
			
			<div class="form-group">
			<label>Select hobby</label><br> 
			<input type="checkbox" name="hobby" value="Dancing"><label>Dancing</label><br>
			<input type="checkbox" name="hobby" value="Singing"><label>Singing</label><br>
			<input type="checkbox" name="hobby" value="Painting"><label>Painting</label><br>
			</div>
			
			<input type="submit" value="submit" class="btn btn-success">
		</form>
	</div>
	
	<div class="container">
	<h2> Employee Data </h2>
	<table class="table table-striped">
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>E-mail</th>
	<th>Gender</th>
	<th>D.O.B.</th>
	<th>Hobby</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	
	<%
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbURL = "jdbc:mysql://localhost:3306/";
	String dbName = "mysql_database";
	String dbUsername = "root";
	String dbPassword = "ignek@12345";
	Class.forName(dbDriver);
	Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
	String query="select * from Employee";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	while(rs.next())
	{
	%>
		<tr>
		<th><%=rs.getInt(1) %></th>
		<th><%=rs.getString(2) %></th>
		<th><%=rs.getString(3) %></th>
		<th><%=rs.getString(4) %></th>
		<th><%=rs.getString(5) %></th>
		<th><%=rs.getString(6) %></th>
		<th><a href="EditServlet?emp_id=<%=rs.getString(1)%>" type="submit" id="delete"><button class="btn btn-warning">update</button></a></th>
		<th><a href="DeleteServlet?id=<%=rs.getString(1)%>" type="submit" id="delete"><button class="btn btn-danger">Delete</button></a></th>
		</tr>	
	<%	
	  }
	%>
	</table>
	</div>
</body>
</html>