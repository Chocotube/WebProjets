<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>View</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

	
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
<body>

<!--  Upload -->


<!-- View File Upload -->	
      
        
     <div class="container centered">

	<nav class="navbar fixed-top navbar-dark bg-warning"></nav>

<%-- 
<hr>

	<h1 align="center" style="font-family:system-ui;"> OR</h1>
		
<hr>

--%>


<div class="card">
  <div class="card-header bg-success">
  	 <h2 style="font-family:system-ui;color:white;" > Your files </h2>
  </div>
  
  
  <div class="card-body">
    <div class="row mt-3">
		<div class="col">

			<table class="table table-bordered table-striped table-hover">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
			
		</div>
	</div>
  </div>
</div>

<hr>

<div class="card text-center">
<div class="card">
  <div class="card-header bg-warning">
  	 <h2 style="font-family:system-ui;color:white;"> Upload </h2>
  </div>
  
  
  <div class="card-body">
    <div class="row mt-3">
		<div class="col-sm-6 offset-sm-3 text-center">
			<div class="form-group -animated">
			<form action="Upload?name=${param.name}" method="post" enctype="multipart/form-data">
		
				<input class="form control" type="file" name="file1" /> <br/>
		<hr>
				<input class="btn btn-light" type="submit" name="upload" value="Upload" />
				</form>
			</div>
		</div>
	</div>
  </div>
</div>
</div>

<hr> 

<div class="card text-center">
<div class="card">
  <div class="card-header bg-danger">
  	 <h2 style="font-family:system-ui;color:white;" > Delete </h2>
  </div>
  
  
  <div class="card-body">
    <div class="row mt-3">
		<div class="col-sm-6 offset-sm-3 text-center">
			<div class="form-group -animated">
			<form action="delete?name=${param.name}" method="post">
				<input class="form-control" type="text" placeholder="Enter the filename that you want to delete" name="filename">
				<br>
				<input class="btn btn-light" type="submit" value="Delete" name="delete">
			</form>
			</div>
		</div>
	</div>
  </div>
</div>
</div>

<hr>

<div class="card text-center">
<div class="card">
  <div class="card-header bg-primary">
  	 <h2 style="font-family:system-ui;color:white;" > Rename </h2>
  </div>
  
  
  <div class="card-body">
    <div class="row mt-3">
		<div class="col-sm-6 offset-sm-3 text-center">
			<div class="form-group -animated">
			<form action="rename?name=${param.name}" method="post">
				<input class="form-control" type="text" placeholder="Enter the entire filename to change (extension included)" name="filename">
				<br>
				<input class="form-control" type="text" placeholder="New filename (extension included)" name="rename">
				<br>
				<input class="btn btn-light" type="submit" value="Rename" name="rename">
			</form>
			</div>
		</div>
	</div>
  </div>
</div>
</div>

<hr>

<div class="card text-center">
<div class="card">
  <div class="card-header bg-primary">
  	 <h2 style="font-family:system-ui;color:white;" > Download </h2>
  </div>
  
  
  <div class="card-body">
    <div class="row mt-3">
		<div class="col-sm-6 offset-sm-3 text-center">
			<div class="form-group -animated">
			<form action="Download?name=${param.name}" method="post">
				<input class="form-control" type="text" placeholder="Enter the file that you want to download(extension included)" name="filename">
				<br>
				<input class="btn btn-light" type="submit" value="Download" name="download">
			</form>
			</div>
		</div>
	</div>
  </div>
</div>
</div>

<hr>

<div class="card text-center">
<div class="card" >
  <div class="card-body" >
    <div class="row mt-3">
		<div class="col-sm-6 offset-sm-3 text-center">
			<a class="btn btn-light" href="Login_Register.jsp"> Log Off </a>
		</div>
	</div>
  </div>
</div>
</div>
	
</div>
    
        
</body>
</html>