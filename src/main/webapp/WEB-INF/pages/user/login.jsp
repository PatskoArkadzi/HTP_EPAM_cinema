<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta http-equiv="Content-Type"
	content="width=device-width, initial-scale=1, shrink-to-fit=no, text/html"
	charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<title>Cinema</title>
</head>
<body>
	<c:import url="../include/header.jsp" />


	<form method="post" action="cinema?action=log_in">
		<div class="form-group">
			<label class="col-md-2">login</label> <input placeholder="login"
				id="userLogin" name="userLogin" required="required" value="admin" />
		</div>
		<div class="form-group">
			<label class="col-md-2">password</label> <input
				placeholder="password" id="userPassword" name="userPassword"
				required="required" value="password" />
		</div>
		<div class="col-md-4">
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">log
				in</button>
		</div>
	</form>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>