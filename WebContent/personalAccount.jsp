
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Personal account</title>
</head>
<body>
	<div class="buffer">

	<jsp:include page="/WEB-INF/headBar.jsp" />

	<c:if test="${user.banned eq true}">
		<label>Unfortunately, you have no access to this page, because you were banned by application administration.</label>
	</c:if>
	
	<c:if test="${user.banned ne true}">
	<div>
		<label><b>Hello, ${user.fullName}</b> </label></div>
		<c:if test="${orders.size() ne 0}">
	<div><label>Here is your order history: </label></div>
	<table border="1" style="width: 50%">
		<tr>
			<th><label>Tour</label></th>
			<th><label>Status</label></th>
		</tr>
			<c:set var="k" value="0" />
		<c:forEach var="order" items="${orders}">
			<c:set var="k" value="${k+1}" />
			<tr>
				<td><form action="controller" method="post">
						<input type="hidden" name="tourId" value="${order.idTour}">
						<input type="hidden" name="userId" value="${order.idUser}">
						<input type="hidden" name="action" value="tourDetails"> 
						<input
							id="table_button" type="submit" value="${order.tourInfo}" />
					</form></td>
				<td><label>${order.status}</label></td>
			<tr>
		</c:forEach>	
		</table>
		
		<p>Your personal sale is <b>${personalSale}%</b> at the moment!</p>	
	</c:if></c:if>

</div>
	
</body>
</html>