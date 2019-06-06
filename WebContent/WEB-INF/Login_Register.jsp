<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<style type="text/css">
		body{
			padding-top: 3em;
		}
		
		input[type=text] 
		{
  			-webkit-transition: width 1s ease-in-out;
  			transition: width 1s ease-in-out;
		}

		input[type=text]:focus 
		{
  			width: 100%;
		}
		
	</style>
</head>
<body>

<div class="container centered">

	<nav class="navbar fixed-top navbar-dark bg-warning"></nav>

<div class="card text-center">
<div class="card">
  <div class="card-header bg-primary">
  	 <h2 style="font-family:system-ui;color:white;"> Register </h2>
  </div>
  
  
  <div class="card-body">
    <div class="row mt-3">
		<div class="col-sm-6 offset-sm-3 text-center">
			<div class="form-group -animated">
			<form action="register" method="post">

				<c:if test="${ not empty UsernameError }">
				<p>${ UsernameError }</p>
				</c:if>
				<br>
	
				<input class="form-control" type="text" name="name" value="${param.name}" placeholder="Enter your name">
				<br>
	
				<p>${ messageError }</p>
		
				<input class="form-control" type="password" name="password" placeholder="Enter your password" value="${ param.password }">
				<br>
				<input class="btn btn-light" type="submit" name="user" value="Register">

				</form>
			</div>
		</div>
	</div>
  </div>
</div>
</div>

<hr>
<%-- 
<hr>

	<h1 align="center" style="font-family:system-ui;"> OR</h1>
		
<hr>

--%>

<div class="card text-center">
<div class="card">
  <div class="card-header bg-success">
  	 <h2 style="font-family:system-ui;color:white;" > Log In </h2>
  </div>
  
  
  <div class="card-body">
    <div class="row mt-3">
		<div class="col-sm-6 offset-sm-3 text-center">
			<div class="form-group -animated">
			<form action="Login" method="post">
				<input class="form-control" type="text" placeholder="Enter your username" name="name">
				<br>
				<input class="form-control" type="password" placeholder="Enter your password" name="password">
				<br>
				<input class="btn btn-light" type="submit" value="Log In" name="Login">
			</form>
			</div>
		</div>
	</div>
  </div>
</div>
</div>



</div>





</body>
</html>