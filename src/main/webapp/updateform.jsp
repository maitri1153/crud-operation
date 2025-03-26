<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays"%>
<%@page import="java.sql.*" %>
			
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update data</title>
</head>
<body>
	<div>
		<form action="EditServlet" method="post">
			<h1>Update Data</h1>
			<%
				String dbDriver = "com.mysql.cj.jdbc.Driver";
				String dbURL = "jdbc:mysql://localhost:3306/";
				String dbName = "mysql_database";
				String dbUsername = "root";
				String dbPassword = "ignek@12345";
				Class.forName(dbDriver);
				Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
				PreparedStatement ptst;
				ResultSet rs;
				
				int emp_id = Integer.valueOf(request.getParameter("emp_id"));
				ptst = con.prepareStatement("select * from Employee where emp_id=?");
				ptst.setInt(1,emp_id);
				rs=ptst.executeQuery();
				
				while(rs.next())
				{
					%>
			<label>ID </label><br> 
			<input type="text" name="emp_id" value="<%=rs.getString(1)%>"> <br><br> 
			
			<label>Full Name </label><br> 
			<input type="text" name="fname" value="<%=rs.getString(2)%>"> <br><br> 
			
			<label>E-mail</label><br> 
			<input type="email" name="email" value="<%=rs.getString(3)%>"> <br> <br> 
			
			<label>Select Gender</label><br> 
			<input type="radio" id="gender" name="gender" value="female" checked="true"> 
			<label>Female</label><br> 
			<input type="radio" id="gender" name="gender" value="male"> 
			<label>Male</label>
			<br> <br> 
			
			<label> Select Date of Birth </label><br> 
			<input type="date" name="dob" value="<%=rs.getString(5)%>"> <br> <br> 
			
			<label>Select hobby</label><br> 
			<input type="checkbox" name="hobby" value="Dancing"><label>Dancing</label><br>
			<input type="checkbox" name="hobby" value="Singing"><label>Singing</label><br>
			<input type="checkbox" name="hobby" value="Painting" checked="true"><label>Painting</label><br>
			<br> <br> 
			
			<% } %>
			<input type="submit" value="update"></a>		
		</form>
	</div>
</body>
</html>