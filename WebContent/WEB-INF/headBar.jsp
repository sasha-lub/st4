<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div id="bar">
		<h1>blabla tour.</h1>
		<ul>
			<li><a href="login.jsp">Home</a></li>
			<li><a href="#news">News</a></li>
			<c:if test="${user ne null}">
				<li><form action="controller" method="post">
						<input type="hidden" name="action" value="logout" /> <input
							id="barbutton" type="submit" value="Logout">
					</form></li>
				<li><form action="controller" method="post">
				
				<input type="hidden" name="userId" value="${user.idUser}">
						 <input
							type="hidden" name="action" value="goToAccount" /> <input
							id="barbutton" type="submit" value="Personal account" />
					</form></li>
			</c:if>
			<c:if test="${user eq null}">
				<li><a href="login.jsp">Login</a></li>
				<li>
					<form action="registration.jsp">
						<input id="barbutton" type="submit" value="Registration" />
					</form>
				</li>
			</c:if>
		</ul>
	</div>
</body>
</html>