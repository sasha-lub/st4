<%@page import="ua.nure.lubchenko.st4.db.DBManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>Title</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div class="buffer">
		<jsp:include page="/WEB-INF/headBar.jsp" />

		<div id="leftsidemenu">
			<form action="controller" method="post">
				<input type="hidden" name="action" value="showTours" /> <input
					class="button" type="submit" value="Tours list">
			</form>
			<hr>
			<c:if test="${user eq null}">
				<div id="heading">
					<h1>Please login</h1>
				</div>
				<form action="controller" method="post">
					<input type="hidden" name="action" value="login" /> <input
						type="text" name="login" placeholder="Login" required="required" />
					<input type="password" name="password" placeholder="Password"
						required="required" /> <input class="button" id="logregbutton" type="submit"
						value="Login">
				</form>
				<p>${message}</p>
				<hr>
				<form action="registration.jsp">
					<input class="button" id="logregbutton" type="submit" value="Registration" />
				</form>
			</c:if>

			<c:if test="${user ne null}">
				<h1>Hi, ${user.fullName}</h1>
			</c:if>

		</div>
		<div id="about">main part some txt blablabla</div>
	</div>
</body>
</html>