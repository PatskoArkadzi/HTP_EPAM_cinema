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

	<h3>Фильмы жанра "${chosenGenre.genreName}"</h3>
	<hr>
	<div class="container">
		<c:forEach items="${chosenGenreFilms}" var="filmEntry">

			<div class="row">
				<h4>${filmEntry.key.filmName}</h4>
			</div>
			<div class="row">
				<div class=col-md-3>
					<a
						href="cinema?action=view_film_page&chosenFilmId=${filmEntry.key.id}"><img
						src="${filmEntry.key.posterUrl}" width="250" height="400" /></a>
				</div>
				<div class="col-md-8 container">
					<div>
						<b>Жанры :</b><br>
						<c:forEach items="${filmEntry.value}" var="genre">
							<a
								href="cinema?action=view_genre_films&chosenGenreId=${genre.id}">
								${genre.genreName} </a>
						</c:forEach>
					</div>
					<br>
					<div>
						<b>Описание :</b> <br> ${filmEntry.key.description}
					</div>
				</div>
			</div>
			<div align="right">
				<a
					href="cinema?action=view_film_page&chosenFilmId=${filmEntry.key.id}"
					class="btn btn-success btn-lg active" role="button"
					aria-pressed="true">Details</a>
			</div>
			<hr>
			<br>
		</c:forEach>
	</div>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>