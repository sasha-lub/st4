<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
		    $("#toggle_search_bar_btn").mouseenter(function(){
		        $("#search_bar").slideDown("slow","swing");
		    }
		    );
		});
		$(document).ready(function(){
		    $("#search_bar").mouseleave(function(){
		        $("#search_bar").slideUp("slow","swing");
		    }
		    );
		});
</script>
</head>
<body>
	<div class="buffer">
		<jsp:include page="/WEB-INF/headBar.jsp" />
		<br>
		<button class="button" id="toggle_search_bar_btn">Show selection criterias</button>
		<div id="search_bar">
			<label>Choose the selection criteria: </label><br>
			<form action="controller" method="post">
				<input type="hidden" name="action" value="selectCriteria">
				<input type="hidden" name="criteria" value="allTours">
				<input class="button search_button" type="submit" value="full catalog" />
			</form>
			<br><br>
			<form action="controller" method="post">
				<input type="hidden" name="action" value="selectCriteria">
				<input type="hidden" name="criteria" value="byType">
			<input class="button search_button" type="submit" value="tour type" />
			<select name="tourType">
				<option value="resort">Resort</option>
				<option value="excursion">Excursion</option>
				<option value="shopping">Shopping</option>
			</select>
			</form>
			<br><br>
			<form action="controller" method="post">
				<input type="hidden" name="action" value="selectCriteria">
				<input type="hidden" name="criteria" value="byCost">
			<input class="button search_button" type="submit" value="cost" />
						<input type="number" name = "minCost">
						<input type="number" name = "maxCost">
			</form>
			<br><br>
			<form action="controller" method="post">
				<input type="hidden" name="action" value="selectCriteria">
				<input type="hidden" name="criteria" value="byPeopleNumber">
			<input class="button search_button" type="submit" value="people number" />
			<input type="number" name = "peopleNumber">
			</form>
			<br><br>
			<form action="controller" method="post">
				<input type="hidden" name="action" value="selectCriteria">
				<input type="hidden" name="criteria" value="byHotelType">
				<input class="button search_button" type="submit" value="hotel type" />
					<select name="hotelType">
						<option value="budget">Budget</option>
						<option value="3*">3*</option>
						<option value="4*">4*</option>
						<option value="5*">5*</option>
						<option value="luxury">5* luxury</option>
					</select>			
			</form>
			<br><br>
		</div>
		<br><br>
		<table>
			<tr>
				<th>#</th>
				<th>Country</th>
				<th>City</th>
				<th>Hotel</th>
				<th>Hotel type</th>
				<th>Tour type</th>
				<th>Cost</th>
				<th>Number of people</th>
				<th>From</th>
				<th>To</th>
				<th>IsHot</th>
				<th>Details</th>
			</tr>
			<c:set var="k" value="0" />
			<c:forEach var="tour" items="${tours}">
				<c:set var="k" value="${k+1}" />
				<tr>
					<td>${tour.idTour}</td>
					<td>${tour.country}</td>
					<td>${tour.city}</td>
					<td>${tour.hotel}</td>
					<td>${tour.hotelType}</td>
					<td>${tour.tourType}</td>
					<c:if test="${tour.isHot eq true}">
						<td>${tour.cost - (tour.cost*hotSale/100)}</td>
					</c:if>
					<c:if test="${tour.isHot ne true}">
						<td>${tour.cost}</td>
					</c:if>
					<td>${tour.peopleNumber}</td>
					<td>${tour.fromDate}</td>
					<td>${tour.toDate}</td>
					<td>${tour.isHot}</td>
					<td><c:if test="${user ne null && user.banned ne true}">
							<form action="controller" method="post">
								<input type="hidden" name="tourId" value="${tour.idTour}">
								<input type="hidden" name="userId" value="${user.idUser}">
								<input type="hidden" name="action" value="tourDetails">
								<input class="button" type="submit" value="Details" />
							</form>
						</c:if> <c:if test="${user ne null && user.banned eq true}">
							<label>you are banned :(</label>
						</c:if> <c:if test="${user eq null}">
							<label>registr to get more info</label>
						</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>