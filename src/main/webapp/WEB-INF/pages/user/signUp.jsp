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


	<form method="post" action="cinema?action=sign_up">
		<div class="form-group">
			<label class="col-md-2">login</label> <input class="col-md-3"
				placeholder="login" onkeyup="checkLogin()" required="required"
				name="login" /> <span class="col-md-2" id="loginResultValue"></span>
		</div>
		<div class="form-group">
			<label class="col-md-2">email</label> <input class="col-md-3"
				placeholder="email" onblur="checkEmail()" required="required"
				name="email" /> <span class="col-md-2" id="emailResultValue"></span>
		</div>
		<div class="form-group">
			<label class="col-md-2">password</label> <input class="col-md-3"
				placeholder="password" onkeyup="checkPassword()" required="required"
				name="password" /> <span class="col-md-2" id="passwordResultValue"></span>
		</div>
		<div class="col-md-4">
			<button class="btn btn-primary">sign up</button>
		</div>
		<!-- <input type="submit" value="sign up" /> -->
	</form>

	<!-- <script type="text/javascript">
	function checkLogin() {
		var data = {
			login : $('#login').val()
		};
		var dataJson = JSON.stringify(data);
		console.log($);
		$.ajax({
			url : 'checkLog',
			data : ({
				jsonLogin : dataJson
			}),
			success : function(data) {
				$('#loginResultValue').html(data);
			}
		});
	}
	function checkEmail() {
		$.ajax({
			url : 'checkEmail',
			data : ({
				email : $('#email').val()
			}),
			success : function(data) {
				$('#emailResultValue').html(data);
			}
		})
	}
	function checkPassword() {
		$.ajax({
			url : 'checkPass',
			data : ({
				password : $('#password').val()
			}),
			success : function(data) {
				$('#passwordResultValue').html(data);
			}
		})
	}
</script> -->


	<%@ include file="../include/footer.jsp"%>

</body>
</html>