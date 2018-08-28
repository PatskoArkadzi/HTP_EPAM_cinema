<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.profile.">
	<fmt:message key="login" var="loginLoc" />
	<fmt:message key="email" var="emailLoc" />
	<fmt:message key="orderNumber" var="orderNumberLoc" />
	<fmt:message key="price" var="priceLoc" />
	<fmt:message key="total" var="totalLoc" />
	<fmt:message key="filmName" var="filmNameLoc" />
	<fmt:message key="date" var="dateLoc" />
	<fmt:message key="time" var="timeLoc" />
	<fmt:message key="seat" var="seatLoc" />
	<fmt:message key="payButton" var="payButtonLoc" />
</fmt:bundle>

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
		<div class=col-md-2>${loginLoc} :</div>
		<div class=col-md-2>${currentUser.login}</div>
	</div>
	<div class="row">
		<div class=col-md-2>${emailLoc} :</div>
		<div class=col-md-2>${currentUser.email}</div>
	</div>

	<c:if test="${currentUserCurrentOrder!=null}">
		<hr style="border: 1px solid black;">
		<div align="center">
			<b>${orderNumberLoc} ${currentUserCurrentOrder.orderNumber}</b>
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
					<div class="col-md-2">${filmNameLoc}:</div>
					<div class="col-md-9">${film.filmName}</div>
					<div class="col-md-2">${dateLoc}:</div>
					<div class="col-md-9">${filmSession.date}</div>
					<div class="col-md-2">${timeLoc}:</div>
					<div class="col-md-9">${filmSession.time}</div>
					<div class="col-md-2">${seatLoc}:</div>
					<div class="col-md-9">${seat.row}/${seat.number}</div>
				</div>
			</div>
			<div align="right">${priceLoc}: ${ticketPrice}</div>
			<hr>
		</c:forEach>

		<div align="right" style="color: red;">
			<div class="container">
				<b>${totalLoc}: ${totalPrice}</b><br> <a
					href="cinema?action=payOrder&currentUserCurrentOrderId=${currentUserCurrentOrder.id}"><button
						class="btn btn-success btn-lg">${payButtonLoc}</button></a>
			</div>
		</div>
	</c:if>

	<%@ include file="../include/footer.jsp"%>

</body>
</html>