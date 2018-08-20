package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.UserService;
import by.htp.epam.cinema.service.impl.UserServiceImpl;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.ValidateNullParamException;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.*;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.*;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.*;

public class LogInAction extends BaseAction {

	private UserService userService = new UserServiceImpl();
	private static Logger logger = LoggerFactory.getLogger(ChosenGenreFilmsViewAction.class);

	@Override
	public Actions executeAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(SESSION_PARAM_CURRENT_USER) != null) {
			session.setAttribute(SESSION_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_LOG_IN_ACTION_REPEATED_LOGGING));
			return Actions.ERROR;
		}
		if (isPost(request)) {
			String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
			String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
			try {
				validateRequestParamNotNull(login, password);
				User user = userService.getUser(login, password);
				session.setAttribute(SESSION_PARAM_CURRENT_USER, user);
				session.setMaxInactiveInterval(500);
				return Actions.HOME;
			} catch (ValidateNullParamException e) {
				session.setAttribute(SESSION_PARAM_ERROR_MESSAGE,
						resourceManager.getValue(ERROR_MSG_LOG_IN_ACTION_INDEFINITE_ERROR));
				return Actions.ERROR;
			} catch (IllegalArgumentException e) {
				session.setAttribute(SESSION_PARAM_ERROR_MESSAGE,
						resourceManager.getValue(ERROR_MSG_LOG_IN_ACTION_INCORRECT_USER_DATA));
				return Actions.ERROR;
			}
		} else
			return Actions.LOG_IN;
	}
}
