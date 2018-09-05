package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.ServiceFactory;
import by.htp.epam.cinema.service.TicketsOrderService;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.HttpManager;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER;

import java.io.IOException;

import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.ACTION_NAME_VIEW_HOME_PAGE;

/**
 * Class implementing BaseAction interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class LogOutAction implements BaseAction {
	/**
	 * ticketsOrderService field
	 */
	private TicketsOrderService ticketsOrderService = ServiceFactory.getTicketsOrderService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) request.getSession().getAttribute(SESSION_PARAM_CURRENT_USER);
		ticketsOrderService.deleteNonPaidOrder(currentUser);

		session.removeAttribute(SESSION_PARAM_CURRENT_USER);
		session.invalidate();
		response.sendRedirect(HttpManager.getLocationForRedirect(ACTION_NAME_VIEW_HOME_PAGE));
	}
}
