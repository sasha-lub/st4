<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body>
<div class="buffer">
	<jsp:include page="/WEB-INF/headBar.jsp" />
	<table border="1" style="width: 100%">
		<tr>
			<th><label>Tour</label></th>
			<th><label>User</label></th>
			<th><label>Status</label></th>
			<th><label>Change status</label></th>
		</tr>
		<c:set var="k" value="0" />
		<c:forEach var="order" items="${orders}">
			<c:set var="k" value="${k+1}" />
			<tr>
				<td><form action="controller" method="post">
						<input type="hidden" name="tourId" value="${order.idTour}">
						<input type="hidden" name="userId" value="${user.idUser}">
						<input type="hidden" name="action" value="tourDetails"> <input
							id="table_button" type="submit" value="${order.tourInfo}" />
					</form></td>

				<td><form action="controller" method="post">
						<input type="hidden" name="userId" value="${order.idUser}">
						<input type="hidden" name="action" value="userDetails"> <input
							id="table_button" type="submit" value="${order.userName}" />
					</form></td>
				<td><label>${order.status}</label></td>
				<td>
					<form action="controller" method="post">
						<select name="status">
							<option value="registered">Registered</option>
							<option value="paid">Paid</option>
							<option value="canceled">Canceled</option>
						</select> <input type="hidden" name="action" value="changeStatus">
						<input type="hidden" name="userId" value="${order.idUser}">
						<input type="hidden" name="tourId" value="${order.idTour}">
						<input class="button" id="table_button" type="submit" value="Apply" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>