package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.UserService;
import by.htp.epam.cinema.service.impl.UserServiceImpl;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.PasswordSecurity;
import by.htp.epam.cinema.web.util.ValidateNullParamException;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.*;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_SIGN_UP_ACTION_INDEFINITE_ERROR;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.*;

public class SignUpAction extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(SignUpAction.class);
	private UserService userService = new UserServiceImpl();

	@Override
	public Actions executeAction(HttpServletRequest request) {
		if (!isPost(request)) {
			return Actions.SIGN_UP;
		}
		String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
		String email = request.getParameter(REQUEST_PARAM_USER_EMAIL);
		String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
		try {
			validateRequestParamNotNull(login, email, password);
			String resultOfCheck = userService.checkUserData(login, email);
			if (resultOfCheck.length() == 0) {
				String userSalt = PasswordSecurity.getSalt();
				String userPassword = PasswordSecurity.getHashPassword(password, userSalt);
				User user = new User(0, login, email, userPassword, userSalt, 2);
				userService.addUser(user);
				return Actions.LOG_IN;
			} else {
				request.getSession().setAttribute(SESSION_PARAM_ERROR_MESSAGE, resourceManager.getValue(resultOfCheck));
				return Actions.ERROR;
			}
		} catch (ValidateNullParamException e) {
			request.getSession().setAttribute(SESSION_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_SIGN_UP_ACTION_INDEFINITE_ERROR));
			return Actions.ERROR;
		}
	}
}
