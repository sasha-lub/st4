<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="buffer">
	<jsp:include page="/WEB-INF/headBar.jsp" />

	<table>
		<tr>
			<th>#</th>
			<th>Login</th>
			<th>Full name</th>
			<th>Role</th>
			<th>Banned?</th>
			<th colspan="2">Edit</th>
		</tr>
		<c:set var="k" value="0" />
		<c:forEach var="user" items="${users}">
			<c:set var="k" value="${k+1}" />
			<tr>
				<td>${user.idUser}</td>
				<td>${user.login}</td>
				<td>${user.fullName}</td>
				<td>${user.role}</td>
				<td>${user.banned}</td>
				<td>
					<form action="controller" method="post">
						<input type="hidden" name="userId" value="${user.idUser}">
						<input type="hidden" name="action" value="deleteUser" /> <input
							class="button" type="submit" value="Delete" />
					</form>
				</td>
				<td>
					<form action="controller" method="post">
						<input type="hidden" name="userId" value="${user.idUser}">
						<input type="hidden" name="action" value="userDetails" /> <input
							class="button" type="submit" name="userId" value="Details" />
					</form>					
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>