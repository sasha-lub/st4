<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body>
	<div class="buffer">

	<jsp:include page="/WEB-INF/headBar.jsp" />

	<div>
		<b>id: </b>${user.idUser}</div>
	<div>
		<b>full name: </b>${user.fullName}</div>
	<div>
		<b>login: </b>${user.login}</div>
	<div>
		<b>role: </b>${user.role}</div>
	<div>
		<b>is banned: </b>${user.banned}</div>


	<c:if test="${user.banned eq true}">
		<form action="controller" method="post">
			<input type="hidden" name="userId" value="${user.idUser}"> <input
				type="hidden" name="action" value="unbanUser" /> 
				<input class="button" type="submit" value="Unban" />
		</form>
	</c:if>

	<c:if test="${user.banned eq false}">
		<form action="controller" method="post">
			<input type="hidden" name="userId" value="${user.idUser}">
			<input type="hidden" name="action" value="banUser" /> 
			<input class="button" type="submit" value="Ban" />
		</form>
	</c:if>
	</div>
</body>
</html>