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

	<!-- CRUD films -->

	<div class="container">
		<button class="btn btn-success btn-lg" type="button"
			data-toggle="collapse" data-target="#collapseExample"
			aria-expanded="false" aria-controls="collapseExample">Create</button>

		<div class="collapse" id="collapseExample">
			<div class="card card-body">
				<div class="container">
					<div class="row">
						<div class=col-md-2>FilmName</div>
						<div class=col-md-4>Description</div>
						<div class=col-md-2>PosterUrl</div>
						<div class=col-md-2>VideoId</div>
						<div class=col-md-2>Genres</div>
					</div>
				</div>

				<form class="create-film" action="cinema?action=crud_film&filmId=0"
					method=POST>
					<div class="row">
						<div class=col-md-2>
							<input id="filmName" class="form-control input-md"
								name="filmName" />
						</div>
						<div class=col-md-4>
							<input id="filmDescription" class="form-control input-md"
								name="filmDescription" />
						</div>
						<div class=col-md-2>
							<input id="filmPosterUrl" class="form-control input-md"
								name="filmPosterUrl" />
						</div>
						<div class=col-md-2>
							<input id="filmYouTubeVideoId" class="form-control input-md"
								name="filmYouTubeVideoId" />
						</div>
						<div class=col-md-2>
							<select id="genre" class="form-control" name="filmGenresId"
								multiple="multiple" size="5" required>
								<option disabled>Выберите жанр</option>
								<c:forEach items="${genrelist}" var="genre">
									<option value="${genre.id}">${genre.genreName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<button id="create" value="create" name="crudCommand"
						class="btn btn-success">ok</button>
				</form>
			</div>
		</div>
	</div>
	<hr>
	<div class="container">
		<p>Введите id для поиска</p>
		<form class="read-film" action="cinema?action=crud_film" method=POST>
			<div class="row">
				<div class=col-md-2>
					<input id="filmId" class="form-control input-md" name="filmId" />
				</div>
				<button id="read" value="read" name="crudCommand"
					class="btn btn-success">search</button>
			</div>
			<p>Результат поиска:</p>
			<p>${foundFilm}</p>
		</form>
	</div>
	<hr>
	<br>
	<div class="container">
		<c:forEach items="${filmWithGenres}" var="filmEntry">

			<form class="update-user" action="cinema?action=crud_film"
				method=POST>

				<div class="row">
					<div class=col-md-3>ID :</div>
					<div class=col-md-9>
						<input id="filmId" class="form-control input-md" name="filmId"
							value="${filmEntry.key.id}" readonly="readonly" />
					</div>
				</div>
				<div class="row">
					<div class=col-md-3>FilmName :</div>
					<div class=col-md-9>
						<input id="filmName" class="form-control input-md" name="filmName"
							value="${filmEntry.key.filmName}" />
					</div>
				</div>
				<div class="row">
					<div class=col-md-3>PosterUrl :</div>
					<div class=col-md-9>
						<input id="filmPosterUrl" class="form-control input-md"
							name="filmPosterUrl" value="${filmEntry.key.posterUrl}" />
					</div>
				</div>
				<div class="row">
					<div class=col-md-3>youTubeVideoId :</div>
					<div class=col-md-9>
						<input id="filmYouTubeVideoId" class="form-control input-md"
							name="filmYouTubeVideoId" value="${filmEntry.key.youTubeVideoId}" />
					</div>
				</div>

				<div class="row">
					<div class=col-md-3>Description :</div>
					<div class=col-md-9>
						<textarea id="filmDescription" name="filmDescription" cols="100"
							rows="7">${filmEntry.key.description} </textarea>
					</div>
				</div>
				<div class="row">
					<div class=col-md-3>Genres :</div>
					<div class=col-md-5>
						<select id="filmGenresId" class="form-control" name="filmGenresId"
							multiple="multiple" size="5" required>
							<option disabled>Выберите жанр</option>
							<c:forEach items="${genrelist}" var="genre">
								<option value="${genre.id}"
									${filmEntry.value.contains(genre)?"selected":""}>
									${genre.genreName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<button id="update" value="update" name="crudCommand"
					class="btn btn-success">Обновить</button>

				<button id="delete" value="delete" name="crudCommand"
					class="btn btn-danger">Удалить</button>
			</form>
			<br>
		</c:forEach>
	</div>

	<%@ include file="../include/footer.jsp"%>

</body>
</html>