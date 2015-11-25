<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html charset=utf-8">
	<title>Title </title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div class="buffer">
	<jsp:include page="/WEB-INF/headBar.jsp" />
		<div id="heading">
			<h1>Fill the form, please</h1>
		</div>
		
		<form id="registration_form" action="controller" method="post">
			<input type="hidden" name="action" value="register" />
			<input type="text" name="fullName" placeholder="Full name" required="required" /><br>
			<input type="text" name="login" pattern="[A-Za-zА-Яа-я]{5,}" placeholder="Login" required="required" /><br>
			<input type="password" name="password1" placeholder="Password" required="required" /><br>
			<input type="password" name="password2" placeholder="Confirm password" required="required" /><br><br>

			<input class="button" type="submit" value="Registr">  
		</form>
	</div>
</body>
</html>