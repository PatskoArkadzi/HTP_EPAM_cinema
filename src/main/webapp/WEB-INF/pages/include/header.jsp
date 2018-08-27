<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/custom.tld" prefix="cctg"%>
<div class="container">
	<nav class="navbar navbar-light bg-light">
		<div class="row mx-auto">
			<a class="nav-link"
				href="cinema?action=change_locale&localeLanguage=en&localeCountry=US">eng</a>
			<a class="nav-link"
				href="cinema?action=change_locale&localeLanguage=ru&localeCountry=RU">rus</a>
		</div>
	</nav>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/cinema">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="nav navbar-nav">
				<c:if test="${currentUser.role_id==1}">
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">admin
							commands</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="cinema?action=change_user_role">Change
								user role</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="cinema?action=crud_film">CRUD
								film</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="cinema?action=crud_filmSession">CRUD
								filmSession</a>
						</div>
					</div>
				</c:if>
			</ul>
			<ul class="nav navbar-nav mx-auto">
				<li id="timer" style="color: #FF0000; font-size: 30px;" />
			</ul>
			<ul class="nav navbar-nav ml-auto">
				<c:choose>
					<c:when test="${currentUser!=null}">
						<li class="nav-item active"><a class="nav-link"
							href="cinema?action=view_profile" style="color: #FF0000"><b>${currentUser.login}</b></a></li>
						<li class="nav-item active"><a class="nav-link"
							href="cinema?action=log_out">log out</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item active"><a class="nav-link"
							href="cinema?action=log_in">log in</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="cinema?action=sign_up">sign up</a></li>
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