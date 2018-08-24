package by.htp.epam.cinema.web.action.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.domain.BaseEntity;
import by.htp.epam.cinema.domain.Ticket;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.TicketService;
import by.htp.epam.cinema.service.TicketsOrderService;
import by.htp.epam.cinema.service.impl.TicketServiceImpl;
import by.htp.epam.cinema.service.impl.TicketsOrderServiceImpl;
import by.htp.epam.cinema.web.action.BaseAction;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_USER_PROFILE;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CURRENT_USER_CURRENT_ORDER;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CURRENT_USER_CURRENT_ORDER_TICKETS;

public class ProfileViewAction implements BaseAction {

	private TicketsOrderService ticketsOrderService = new TicketsOrderServiceImpl();
	private TicketService ticketsService = new TicketServiceImpl();

	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User currentUser = (User) request.getSession().getAttribute(SESSION_PARAM_CURRENT_USER);
		TicketsOrder ticketsOrder = ticketsOrderService.readUserNonPaidOrder(currentUser);
		if (ticketsOrder != null) {
			Map<Ticket, List<BaseEntity>> currentOrderTickets = ticketsService.getOrderTickets(ticketsOrder);
			request.setAttribute(REQUEST_PARAM_CURRENT_USER_CURRENT_ORDER, ticketsOrder);
			request.setAttribute(REQUEST_PARAM_CURRENT_USER_CURRENT_ORDER_TICKETS, currentOrderTickets);
		}
		request.getRequestDispatcher(PAGE_USER_PROFILE).forward(request, response);
	}
}
