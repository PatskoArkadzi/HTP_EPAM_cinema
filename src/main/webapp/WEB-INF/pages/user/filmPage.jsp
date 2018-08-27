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

	<div class="row">
		<h4>${chosenFilm.filmName}</h4>
	</div>
	<div class="row">
		<div class=col-md-3>
			<img src="${chosenFilm.posterUrl}" width="250" height="400" /> <b>Выберите
				дату и время:</b> <br>
			<c:forEach items="${chosenFilmFilmSessions}" var="session">
				<a
					href="cinema?action=choose_seat&chosenFilmSessionId=${session.id}"
					class="btn btn-success btn-lg active" role="button"
					aria-pressed="true">${session.date} ${session.time}</a>
				<br>
			</c:forEach>
		</div>
		<div class="col-md-8 container">
			<div>
				<b>Жанры :</b><br>
				<c:forEach items="${chosenFilmGenres}" var="genre">
								${genre.genreName}
						</c:forEach>
			</div>
			<br>
			<div>
				<b>Описание :</b> <br> ${chosenFilm.description}
			</div>
			<br>
			<iframe width="600" height="400"
				src="https://www.youtube.com/embed/${chosenFilm.youTubeVideoId}">
			</iframe>
		</div>
	</div>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>