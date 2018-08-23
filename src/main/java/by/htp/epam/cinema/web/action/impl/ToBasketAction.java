package by.htp.epam.cinema.web.action.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.FilmSessionService;
import by.htp.epam.cinema.service.SeatService;
import by.htp.epam.cinema.service.TicketService;
import by.htp.epam.cinema.service.TicketsOrderService;
import by.htp.epam.cinema.service.impl.FilmSessionServiceImpl;
import by.htp.epam.cinema.service.impl.SeatServiceImpl;
import by.htp.epam.cinema.service.impl.TicketServiceImpl;
import by.htp.epam.cinema.service.impl.TicketsOrderServiceImpl;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.HttpManager;
import by.htp.epam.cinema.web.util.Timer;
import by.htp.epam.cinema.web.util.ValidateNullParamException;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_SEAT_ID;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_IS_TIMER_NEED;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_ERROR;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_ERROR_MESSAGE;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_TO_BASKET_ACTION_INDEFINITE_ERROR;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_TO_BASKET_ACTION_SEAT_IS_NOT_FREE_ERROR;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_TO_BASKET_ACTION_USER_IS_NOT_LOGGED_IN_ERROR;

import java.io.IOException;

import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.ACTION_NAME_CHOOSE_SEAT;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_FILMSESSION_ID;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateRequestParamNotNull;;

public class ToBasketAction implements BaseAction {

	private static Logger logger = LoggerFactory.getLogger(ToBasketAction.class);
	SeatService seatService = new SeatServiceImpl();
	FilmSessionService filmSessionService = new FilmSessionServiceImpl();
	TicketsOrderService ticketsOrderService = new TicketsOrderServiceImpl();
	TicketService ticketService = new TicketServiceImpl();

	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SESSION_PARAM_CURRENT_USER);
		if (user != null) {
			String chosenSeatIdString = request.getParameter(REQUEST_PARAM_CHOSEN_SEAT_ID);
			String chosenFilmSessioIdString = request.getParameter(REQUEST_PARAM_CHOSEN_FILMSESSION_ID);
			try {
				validateRequestParamNotNull(chosenSeatIdString, chosenFilmSessioIdString);
				int chosenSeatIdInt = Integer.parseInt(chosenSeatIdString);
				int chosenFilmSessioIdInt = Integer.parseInt(chosenFilmSessioIdString);
				Seat chosenSeat = seatService.getSeat(chosenSeatIdInt);
				if (!seatService.isSeatFree(chosenSeatIdInt, chosenFilmSessioIdInt)) {
					request.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
							resourceManager.getValue(ERROR_MSG_TO_BASKET_ACTION_SEAT_IS_NOT_FREE_ERROR));
					request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
				}
				FilmSession chosenFilmSession = filmSessionService.getFilmSession(chosenFilmSessioIdInt);
				TicketsOrder ticketsOrder;
				if ((ticketsOrder = ticketsOrderService.readUserNonPaidOrder(user)) == null) {
					logger.info(ticketsOrderService.createTicketsOrder(user).toString());

					Timer timer = new Timer();
					timer.start();
					logger.info("timer.start()");
					session.setAttribute(SESSION_PARAM_IS_TIMER_NEED, true);
				}
				ticketService.createTicket(chosenFilmSession, chosenSeat, ticketsOrder);
			} catch (ValidateNullParamException e) {
				request.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
						resourceManager.getValue(ERROR_MSG_TO_BASKET_ACTION_INDEFINITE_ERROR));
				request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
			}
			response.sendRedirect(HttpManager.getLocationForRedirect(ACTION_NAME_CHOOSE_SEAT));
		} else {
			request.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_TO_BASKET_ACTION_USER_IS_NOT_LOGGED_IN_ERROR));
			request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
		}
	}
}
