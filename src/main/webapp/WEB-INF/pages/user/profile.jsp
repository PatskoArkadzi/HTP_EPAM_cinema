<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>

<div class="row">
	<div class=col-md-2>login :</div>
	<div class=col-md-2>${currentUser.login}</div>
</div>
<div class="row">
	<div class=col-md-2>email :</div>
	<div class=col-md-2>${currentUser.email}</div>
</div>

<c:if test="${currentUserCurrentOrder!=null}">
	<hr style="border: 1px solid black;">
	<div align="center">
		<b>Order № ${currentUserCurrentOrder.orderNumber}</b>
	</div>

	<c:set var="totalPrice" value="0" />
	<c:forEach items="${currentUserCurrentOrderTickets}" var="ticketEntry"
		varStatus="loop">

		<c:set var="filmSession" value="${ticketEntry.value.get(0)}" />
		<c:set var="film" value="${ticketEntry.value.get(1)}" />
		<c:set var="seat" value="${ticketEntry.value.get(2)}" />
		<c:set var="ticketPrice" value="${filmSession.ticketPrice}" />
		<c:set var="totalPrice" value="${totalPrice+ticketPrice}" />

		<div class="row">
			<div class="col-md-0.5">${loop.count}.</div>
			<div class="row col-md-11">
				<div class="col-md-2">film name:</div>
				<div class="col-md-9">${film.filmName}</div>
				<div class="col-md-2">date:</div>
				<div class="col-md-9">${filmSession.date}</div>
				<div class="col-md-2">time:</div>
				<div class="col-md-9">${filmSession.time}</div>
				<div class="col-md-2">seat(r/n):</div>
				<div class="col-md-9">${seat.row}/${seat.number}</div>
			</div>
		</div>
		<div align="right">price: ${ticketPrice}</div>
		<hr>
	</c:forEach>

	<div align="right" style="color: red;">
		<div class="container">
			<b>total: ${totalPrice}</b><br> <a
				href="cinema?action=pay?currentUserCurrentOrderId=${currentUserCurrentOrder.id}"><button
					class="btn btn-success btn-lg">Pay</button></a>
		</div>
	</div>
</c:if>

<%@ include file="../include/end-html.jsp"%>