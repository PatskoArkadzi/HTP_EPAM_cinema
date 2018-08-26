<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<!-- CRUD FilmSession -->
<div class="container">
	<button class="btn btn-success btn-lg" type="button"
		data-toggle="collapse" data-target="#collapseExample"
		aria-expanded="false" aria-controls="collapseExample">Create
		FilmSession</button>

	<div class="collapse" id="collapseExample">
		<div class="card card-body">
			<div class="container">
				<div class="row">
					<div class=col-md-3>Film</div>
					<div class=col-md-3>Date</div>
					<div class=col-md-2>Time</div>
					<div class=col-md-2>TicketPrice</div>
				</div>

				<form class="create-filmSession"
					action="cinema?action=crud_filmSession&filmSessionId=0" method=POST>
					<div class="row">
						<div class=col-md-3>
							<select id="filmId" class="form-control" name="filmId"
								required="required">
								<c:forEach items="${filmlist}" var="film">
									<option value="${film.id}">${film.filmName}</option>
								</c:forEach>
							</select>
						</div>
						<div class=col-md-3>
							<input id="filmSessionDate" type="date"
								class="form-control input-md" name="filmSessionDate"
								required="required" />
						</div>
						<div class=col-md-2>
							<input id="filmSessionTime" type="time"
								class="form-control input-md" name="filmSessionTime"
								required="required" />
						</div>
						<div class=col-md-2>
							<input id="filmSessionTicketPrice" class="form-control input-md"
								name="filmSessionTicketPrice" placeholder="price"
								required="required" />
						</div>
						<button id="create" value="create" name="crudCommand"
							class="btn btn-success">ok</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<hr>
<div class="container">
	<p>Введите id фильма для поиска киносеансов</p>
	<form class="read-film" action="cinema?action=crud_filmSession"
		method=POST>
		<div class="row">
			<div class=col-md-2>
				<input id="filmId" class="form-control input-md" name="filmId" />
			</div>
			<button id="read" value="read" name="crudCommand"
				class="btn btn-success">search</button>
		</div>
	</form>
</div>
<hr>

<c:if test="${foundFilmSessions.size()>0}">
	<div class="container">
		<div class="row">
			<div class=col-md-1>ID</div>
			<div class=col-md-4>Film</div>
			<div class=col-md-3>Date</div>
			<div class=col-md-2>Time</div>
			<div class=col-md-2>TicketPrice</div>
		</div>
	</div>
	<div class="container">
		<c:forEach items="${foundFilmSessions}" var="filmSession">
			<form action="cinema?action=crud_filmSession" method=POST>
				<div class="row">
					<div class="col-md-1">
						<input id="filmSessionId" class="form-control input-md"
							name="filmSessionId" value="${filmSession.id}"
							readonly="readonly" />
					</div>
					<div class=col-md-4>
						<select id="filmId" class="form-control" name="filmId"
							required="required">
							<c:forEach items="${filmlist}" var="film">
								<option value="${film.id}"
									${film.id==filmSession.film_id? 'selected':''}>${film.filmName}</option>
							</c:forEach>
						</select>
					</div>
					<div class=col-md-3>
						<input id="filmSessionDate" type="date"
							class="form-control input-md" name="filmSessionDate"
							required="required" value="${filmSession.date}" />
					</div>
					<div class=col-md-2>
						<input id="filmSessionTime" type="time"
							class="form-control input-md" name="filmSessionTime"
							required="required" value="${filmSession.time}" />
					</div>
					<div class="col-md-2">
						<input id="filmSessionTicketPrice" class="form-control input-md"
							name="filmSessionTicketPrice" placeholder="price"
							required="required" value="${filmSession.ticketPrice}" />
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
</c:if>
<%@ include file="../include/end-html.jsp"%>