package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.UserService;
import by.htp.epam.cinema.service.impl.UserServiceImpl;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_CURRENT_USER;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_USER_LOGIN;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_USER_PASSWORD;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.*;

public class LogInAction extends BaseAction {

	private UserService userService = new UserServiceImpl();

	@Override
	public Actions executeAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(SESSION_PARAM_CURRENT_USER) != null) {
			session.setAttribute(SESSION_PARAM_ERROR_MESSAGE, "You are already logged in");
			return Actions.ERROR;
		}
		if (isPost(request)) {
			String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
			String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
			if (!validateRequestParamNotNull(login, password)) {
				session.setAttribute(SESSION_PARAM_ERROR_MESSAGE, "Something went wrong. Try again.");
				return Actions.ERROR;
			}
			User user = userService.getUser(login, password);
			if (user != null) {
				session.setAttribute(SESSION_PARAM_CURRENT_USER, user);
				session.setMaxInactiveInterval(500);
				return Actions.HOME;
			} else {
				session.setAttribute(SESSION_PARAM_ERROR_MESSAGE, "Incorrect username or password");
				return Actions.ERROR;
			}
		} else
			return Actions.LOG_IN;
	}
}
