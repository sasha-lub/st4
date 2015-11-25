<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body>
<div class="buffer">
	<jsp:include page="/WEB-INF/headBar.jsp" />

	<div>
		<b>id: </b>${tour.idTour}</div>
	<div>
		<b>country: </b>${tour.country}</div>
	<div>
		<b>city: </b>${tour.city}</div>
	<div>
		<b>hotel: </b>${tour.hotel}</div>
	<div>
		<b>hotel type: </b>${tour.hotelType}</div>
	<div>
		<b>tour type: </b>${tour.tourType}</div>
	<div>
		<b>price: </b>${tour.cost}</div>
	<div>
		<b>people number: </b>${tour.peopleNumber}</div>
	<div>
		<b>from: </b>${tour.fromDate}</div>
	<div>
		<b>to: </b>${tour.toDate}</div>
	<div>
		<b>is hot: </b>${tour.isHot}</div>
	<br>
	<br>
	<c:if test="${user.role eq 'ADMIN' || user.role eq 'MANAGER'}">
		<form action="controller" method="post">
			<input type="hidden" name="tourId" value="${tour.idTour}"> <input
				type="hidden" name="action" value="deleteTour" /> <input
				class="button" type="submit" value="Delete" />
		</form>
		<form action="controller" method="post" action="editTour.jsp">
			<input type="hidden" name="tourId" value="${tour.idTour}"> <input
				type="hidden" name="action" value="editTour" /> <input class="button"
				type="submit" value="Update" />
		</form>
	</c:if>
	<c:if test="${user.role eq 'CLIENT'}">
		<label>With your personal discount tour will cost <b>${tour.cost - (tour.cost*personalSale/100)}</b>UAH</label>
		<form action="controller" method="post">
			<input type="hidden" name="tourId" value="${tour.idTour}"> <input
				type="hidden" name="userId" value="${user.idUser}"> <input
				type="hidden" name="action" value="makeAnOrder"> <input
				class="button" type="submit" value="Book" />
		</form>
	</c:if>
	
	<c:if test="${user eq null}">
		<b>Login or registr for booking tour.</b>
	</c:if>
	</div>
</body>
</html>