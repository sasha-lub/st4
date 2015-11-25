<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello admin!</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>
<div class="buffer">
	<jsp:include page="/WEB-INF/headBar.jsp" />
	<p>${message}</p>
	<form id="add_tour_button_form" action="addTour.jsp">
		<input class="button" type="submit" value="Add tour" />
	</form>
	<hr>
	<form id="show_users_button" action="controller" method="post">
		<input type="hidden" name="action" value="showUsers" /> <input
			class="button" type="submit" value="Users list" />
	</form>
	<hr>
	<form id="show_tours_button" action="controller" method="post">
		<input type="hidden" name="action" value="showTours" /> <input
			class="button" type="submit" value="Tours list" />
	</form>
	
	<hr>
	<form id="show_orders_button" action="controller" method="post">
		<input type="hidden" name="action" value="showOrders" /> <input
			class="button" type="submit" value="Orders" />
	</form>
	<hr>
	<form id="manage_prices_button" action="manageSales.jsp">
			<input class="button" type="submit" value="Manage sales" />
		</form>
		
</div>
</body>