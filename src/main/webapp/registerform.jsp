<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<c:if test="${employee != null}">
			<form action="EditServlet" method="post">
		</c:if>
		
		<c:if test="${employee == null}">
			<form action="InsertServlet" method="post">
		</c:if>
		
			<c:if test="${employee != null}">
			<h1>Update Your Details:</h1>
			</c:if>
		
			<c:if test="${employee == null}">
			<h1>Registration Form:</h1>
			</c:if>
			
			<div class="form-group">
			<label>ID</label>
			<c:if test="${employee != null}">
			<input type="text" name="emp_id" class="form-control" value = "${employee.id}">
			</c:if>
		
			<c:if test="${employee == null}">
			<input type="text" name="emp_id" class="form-control" hidden >
			</c:if>
			</div>
			
			<div class="form-group">
			<label>Full Name </label>
			<input type="text" name="fullName" class="form-control" required  value = "${employee.fullName}"/>
			</div>
			
			<div class="form-group">
			<label>E-mail</label>
			<input type="email" name="email" class="form-control" required placeholder="abc@gmail.com" value="${employee.email}"/> 
			</div>
			
			<div class="form-group">
			<label>Select Gender</label><br>
			<input type="radio" id="gender" name="gender" value="female" checked="true"> 
			<label class="form-check-label" for="flexRadioDefault1">Female</label><br>
			
			<input type="radio" id="gender" name="gender" value="male"> 
			<label class="form-check-label" for="flexRadioDefault1">Male</label>
			</div>
			
			<div class="form-group">
			<label> Select Date of Birth </label>
			<input type="date" name="dob" class="form-control" required value="${employee.dob}"/>
			</div>
			
			<div class="form-group">
			<label>Select hobby</label><br> 
			<input type="checkbox" name="hobby" value="Dancing"><label>Dancing</label><br>
			<input type="checkbox" name="hobby" value="Singing"><label>Singing</label><br>
			<input type="checkbox" name="hobby" value="Painting" checked="true"><label>Painting</label><br>
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

	<tbody>
    	<c:forEach var="employee" items="${employeelist}">
    	<tr>
            <td><c:out value="${employee.id}"/></td>
            <td><c:out value="${employee.fullName}" /></td>
            <td><c:out value="${employee.email}"/></td>
            <td><c:out value="${employee.gender}"/></td>
            <td><c:out value="${employee.dob}"/></td>
            <td><c:out value="${employee.hobby}"/></td>
            <td><a href="EditServlet?emp_id=<c:out value='${employee.id}'/>">Edit</a></td>
            <td><a href="DeleteServlet?id=<c:out value='${employee.id}'/>">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
	</table>
	</div>
</body>
</html>