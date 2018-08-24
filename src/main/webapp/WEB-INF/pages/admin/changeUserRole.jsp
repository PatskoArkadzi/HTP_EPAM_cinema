<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<!-- CRUD users -->


<div class="container">
	<p>Введите id для поиска</p>
	<form class="read-user" action="cinema?action=change_user_role"
		method=POST>
		<div class="row">
			<div class=col-md-2>
				<input id="userId" class="form-control input-md" name="userId" />
			</div>
			<button id="read" value="read" name="crudCommand"
				class="btn btn-success">search</button>
		</div>
	</form>
</div>
<hr>

<c:if test="${foundUser!=null}">
	<div class="container">
		<div class="row">
			<div class=col-md-1>ID</div>
			<div class=col-md-2>Login</div>
			<div class=col-md-2>Email</div>
			<div class=col-md-2>Password</div>
			<div class=col-md-2>Salt</div>
			<div class=col-md-2>Role</div>
		</div>
	</div>

	<div class="container">
		<form class="update-user" action="cinema?action=change_user_role"
			method=POST>
			<div class="row">
				<div class=col-md-1>
					<input id="userId" class="form-control input-md" name="userId"
						value="${foundUser.id}" readonly="readonly" />
				</div>
				<div class=col-md-2>
					<input id="userLogin" class="form-control input-md"
						name="userLogin" value="${foundUser.login}" readonly="readonly" />
				</div>
				<div class=col-md-2>
					<input id="userEmail" class="form-control input-md"
						name="userEmail" value="${foundUser.email}" readonly="readonly" />
				</div>
				<div class=col-md-2>
					<input id="userPassword" class="form-control input-md"
						name="userPassword" value="${foundUser.password}"
						readonly="readonly" />
				</div>
				<div class=col-md-2>
					<input id="userSalt" class="form-control input-md" name="userSalt"
						value="${foundUser.salt}" readonly="readonly" />
				</div>
				<div class=col-md-2>
					<select id="userRoleId" class="form-control" name="userRoleId">
						<c:forEach items="${rolelist}" var="role">
							<option value="${role.id}"
								${role.id==foundUser.role_id?"selected":""}>
								${role.roleName}</option>
						</c:forEach>
					</select>
				</div>

				<button id="update" value="update" name="crudCommand"
					class="btn btn-success">Обновить</button>
			</div>
		</form>
	</div>

</c:if>

<%@ include file="../include/end-html.jsp"%>