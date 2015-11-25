<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>Edit tour</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div id="buffer">
	<jsp:include page="/WEB-INF/headBar.jsp" />
		<div class="heading">
			<h1>Please fill the fields</h1>
		</div>

		<form id="add_new_tour_form" action="controller" method="post">
			<input type="hidden" name="tourId" value="${tour.idTour}">
			<input type="hidden" name="action" value="updateTour">  
			<input type="text" name="country" value= "${tour.country}" required="required" /><br/>
			<input type="text" name="city" value="${tour.city}" required="required" /><br/>
			<input type="text" name="hotel" value="${tour.hotel}" required="required" /><br/>
			<input type="text" name="tourType" value="${tour.tourType}" required="required" /><br/>
			<input type="text" name="hotelType" value="${tour.hotelType}" required="required" /><br/>
			<input type="number" name="cost" value="${tour.cost}" required="required" /><br/>
			<input type="number" name="peopleNumber" value="${tour.peopleNumber}" required="required" /><br/>
			from: <input type="date" name="fromDate" value="${tour.fromDate}" required="required" /><br/>
			to: <input type="date" name="toDate" value="${tour.toDate}" required="required" /><br/>	
			<c:if test="${tour.isHot eq true}">
				hot: <input type="checkbox" name="isHot" checked="checked"/> <br/>			
			</c:if>
			<c:if test="${tour.isHot ne true}">
				hot: <input type="checkbox" name="isHot" /> <br/>			
			</c:if>
			<input class="button" type="submit" value="Apply">
			<input class="button" type="reset" value ="Cancel">  
		</form>
		</div>
</body>
</html>