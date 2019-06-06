<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu120"
	user="cs3220stu120"
	password="RKFNkYe6" />

<%-- query --%>
<c:if test="${param.query == 'Execute Query'}">
	<c:catch var="yolo">
	<sql:query var="test">
		${param.sql}
	</sql:query> 
	</c:catch>
	
</c:if>

<%-- update --%>
<c:if test="${param.update == 'Submit Update'}">
	<c:catch var= "yolo">
	<sql:update var="test">
		${param.sql}
	</sql:update> 
	</c:catch>
</c:if>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lab 7 - SQL</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<style type="text/css">
		body{
			padding-top: 3em;
		}
	</style>
</head>
<body>



<div class="container">

	<nav class="navbar fixed-top navbar-light bg-primary">
	  <span class="navbar-brand mb-0 h1">SQL Query</span>
	</nav>
	
	<div class="row mt-3">
		<div class="col">
		
			<form class="mb-4">
			  	<div class="form-group">
			  		<label for="sqlTextArea">Enter your SQL below:</label>
					<textarea class="form-control" id="sqlTextArea" name="sql">${param.sql}</textarea>
				</div>
				
				<input class="btn btn-primary" type="submit" name="query" value="Execute Query">
				<input class="btn btn-warning" type="submit" name="update" value="Submit Update">
			</form>
						
		</div>
	</div> <!-- End div.row -->
</div>
<div>
 <c:if test="${yolo == null}">
	<c:if test="${param.query != null}">
				<p>
					Displaying <strong>${test.rowCount} result(s)</strong> from query: <code>${param.sql}</code>.
				</p>
		<c:if test="${test.rowCount == 0}">
				<p>There is no message yet.</p>
		</c:if>
			
		<c:if test="${test.rowCount > 0}">
			<table class="table table-bordered table-striped table-hover">
				<tr>
	        			<c:forEach var="columnName" items="${test.columnNames}">
	            			<th>${columnName}</th>
	            			</c:forEach>
	            	</tr>
				<c:forEach items="${test.rowsByIndex}" var="row">
					<tr>
			  <c:forEach items="${row}" var="col">
					  	<td>${col}</td>
					  </c:forEach>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	  </c:if>
	  <c:if test="${param.update != null }">
	  		<p>
					Updated <strong>${test} rows(s)</strong> from query: <code>${param.sql}</code>.
			</p>
	  </c:if>
	 </c:if>
</div>
</body>
</html>