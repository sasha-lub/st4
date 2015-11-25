<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>Add new Tour</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="buffer">
	<jsp:include page="/WEB-INF/headBar.jsp" />
		<div class="heading">
			<h1>Please fill the fields</h1>
		</div>
		
		<form id="add_new_tour_form" action="controller" method="post">
			<input type="hidden" name="action" value="addNewTour" /><br/>
			<input type="text" name="country" placeholder="country" required="required" /><br/>
			<input type="text" name="city" placeholder="city" required="required" /><br/>
			<input type="text" name="hotel" placeholder="hotel name" required="required" /><br/>
			<select name="tourType">
				<option value="resort">Resort</option>
				<option value="excursion">Excursion</option>
				<option value="shopping">Shopping</option>
			</select>
			<br/>
			<select name="hotelType">
				<option value="budget">Budget</option>
				<option value="3*">3*</option>
				<option value="4*">4*</option>
				<option value="5*">5*</option>
				<option value="luxury">5* luxury</option>
			</select>
			<input type="number" name="cost" placeholder="cost" required="required" /><br/>
			<input type="number" name="peopleNumber" placeholder="number of people" required="required" /><br/>
			<label>from: </label><input type="date" name="fromDate" required="required" /><br/>
			<label>to: </label><input type="date" name="toDate" required="required" /><br/>
			<label>hot: </label><input type="checkbox" name="isHot" /><br/>

			<input type="submit" value="Add new tour">  
		</form>
		</div>
</body>
</html>