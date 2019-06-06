<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cs3220" uri="https://heeeeeeeey.com/" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Convert stuff</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style type="text/css">
	body{padding-top: 3em;}
</style>
</head>
<body>
<div class="row mt-3">
		<div class="col">
		
			<form class="mb-4">
			  	<div class="form-group">
			  		<label for="convertionTextArea">Enter what you want to convert </label>
					<textarea class="form-control" id="rR" name="value">${param.value}</textarea>
				</div>
				
				<input class="btn btn-submit"  type="submit" value="Convert">
				
			</form>
			
		</div>
	</div>
	
<p>The result is : 
		<br> 
		<font color="green">
		<c:choose>
			<c:when test="${param.value != null}">
				<cs3220:romanNumeral value="${param.value}" />
			</c:when>
			<c:otherwise>
				No result yeat but keep your fingers cross ;)
			</c:otherwise>
		</c:choose>
		</font>
	</p>
</body>
</html>