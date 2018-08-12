<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="cctg"%>
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
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="cinema?action=viewHomePage">Home</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<%-- <ul class="nav navbar-nav">
					<c:if test="${currentUser.roles_id==1}">
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">DataBase
								actions</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="/cinema/newapp/admin/crud/role/">CRUD
									role</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/cinema/newapp/admin/crud/user/">CRUD
									user</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/cinema/newapp/admin/crud/order/">CRUD
									order</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item"
									href="/cinema/newapp/admin/crud/ticket/">CRUD ticket</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/cinema/newapp/admin/crud/seat/">CRUD
									seat</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item"
									href="/cinema/newapp/admin/crud/session/">CRUD session</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/cinema/newapp/admin/crud/film/">CRUD
									film</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/cinema/newapp/admin/crud/genre/">CRUD
									genre</a>
							</div>
						</div>
					</c:if>
				</ul> --%>
				<ul class="nav navbar-nav mx-auto">
					<li id="timer" style="color: #FF0000; font-size: 30px;" />
				</ul>
				<ul class="nav navbar-nav ml-auto">
					<c:choose>
						<c:when test="${currentUser!=null}">
							<li class="nav-item active"><a class="nav-link"
								href="cinema?action=viewProfile" style="color: #FF0000"><b>${currentUser.login}</b></a></li>
							<li class="nav-item active"><a class="nav-link"
								href="cinema?action=logOut">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item active"><a class="nav-link"
								href="cinema?action=logIn">Login</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="cinema?action=signUp">SignUp</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
		<div class="row">
			<div class="col-md-2">
				<br>
				<cctg:DisplayGenresBlock />
			</div>
			<div class="col-md-10">