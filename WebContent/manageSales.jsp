<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage sales</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>

	<div class="buffer">

	<jsp:include page="/WEB-INF/headBar.jsp" />
	<p>${message}</p>
	<form id="set_sales_form" action="controller" method="post">
		
		<div>
			<label>Set sale for HOT tours: </label>
		</div>
		<input type="number" name="hotSale" required="required"/><br />

		<hr>
		<div>
			<label>Set max value for a "step sale": </label>
		</div>
		<input type="number" name="maxStepSale" required="required" /><br>

		<div>
			<label>Set "step sale" value: </label>
		</div>
		<input type="number" name="stepSale" required="required"/><br><br>
		<input type="hidden" name="action" value="manageSales">
		<input id="button"
			type="submit" value="Apply"> <input id="button" type="reset"
			value="Cancel">
	</form>
	
</div>

</body>