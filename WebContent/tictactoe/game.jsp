<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="game" class="tictactoe.board" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>TicTacToe</title>
</head>
<body>
<jsp:setProperty name="game" property="*"/>


<div class="col-sm-6 offset-sm-3">

		<c:choose>
		  <c:when test="${game.status == 'not_tie'}" >
			  <c:if test="${game.turn ne true}" >
			     Player X turn:<br>
			  </c:if>
			  <c:if test="${game.turn == true}" >
		   		Player O turn:<br>
		  	  </c:if>
		  </c:when>
		  <c:when test="${game.status == 'tie'}" >
		  it's a tie
		  </c:when>
		  <c:otherwise>
		  Winner : ${game.status}
		  </c:otherwise>
		</c:choose>



		<table class="table table-bordered table-board">
			<tbody>
			<c:forEach begin="0" end="2" step="1" var="row">
			  <tr>
			  <c:forEach items="${game.board}" begin="${row*3}" end="${row*3+2}" var="box">
			    <td>${box}</td>
			  </c:forEach>
			  </tr>
			 </c:forEach>
		</tbody></table>
		
		<c:if test="${game.status ne 'not_tie'}" >
		   <a href="NewGame">New Game</a>
		  </c:if>

	</div>



</body>
</html>