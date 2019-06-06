<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

<h1>Register</h1>

<form action="register" method="post">

	<c:if test="${ not empty UsernameError }">
		<p>${ UsernameError }</p>
	</c:if>
	<br>
	
	<input type="text" name="username" value="${param.username}" placeholder="Enter your username">
	<br>
	
	<p>${ messageError }</p>
	
	<input name="password" placeholder="Enter your password" value="${ param.password }">
	<br>
	<input type="submit" name="addBtn" value="Register">

</form></body>
</html>