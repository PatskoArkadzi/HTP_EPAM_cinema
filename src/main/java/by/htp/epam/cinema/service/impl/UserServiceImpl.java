package by.htp.epam.cinema.service.impl;

import by.htp.epam.cinema.db.dao.DaoFactory;
import by.htp.epam.cinema.db.dao.UserDao;
import by.htp.epam.cinema.db.pool.impl.ConnectionPool;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.UserService;
import by.htp.epam.cinema.web.util.PasswordSecurity;

import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.*;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.getInt;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateEmailInput;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateRequestParamNotNull;

public class UserServiceImpl implements UserService {

	private UserDao userDao = DaoFactory.getUserDao(ConnectionPool.getInstance());

	@Override
	public User getUser(int userId) {
		return userDao.read(userId);
	}

	@Override
	public User getUser(String login, String password) throws IllegalArgumentException {
		User user = userDao.readByLogin(login);
		if (user != null && user.getPassword().equals(PasswordSecurity.getHashPassword(password, user.getSalt()))) {
			return user;
		} else
			throw new IllegalArgumentException();
	}

	@Override
	public String checkUserData(String login, String email) {
		if (userDao.readByLogin(login) != null)
			return ERROR_MSG_SIGN_UP_ACTION_LOGIN;
		else if (userDao.readByEmail(email) != null)
			return ERROR_MSG_SIGN_UP_ACTION_EMAIL;
		else if (!validateEmailInput(email))
			return ERROR_MSG_SIGN_UP_ACTION_EMAIL_IS_NOT_VALIDATE;
		else
			return "";
	}

	@Override
	public void createUser(String login, String email, String password) {
		String userSalt = PasswordSecurity.getSalt();
		String userPassword = PasswordSecurity.getHashPassword(password, userSalt);
		User user = User.newBuilder().setId(0).setLogin(login).setEmail(email).setPassword(userPassword)
				.setSalt(userSalt).setRole_id(2).build();
		userDao.create(user);
	}

	@Override
	public boolean isUserAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SESSION_PARAM_CURRENT_USER);
		return user != null && user.getRole_id() == 1;
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public User buildUser(HttpServletRequest request) {
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		String userLogin = request.getParameter(REQUEST_PARAM_USER_LOGIN);
		String userEmail = request.getParameter(REQUEST_PARAM_USER_EMAIL);
		String userPassword = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
		String userSalt = request.getParameter(REQUEST_PARAM_USER_SALT);
		String userRoleId = request.getParameter(REQUEST_PARAM_USER_ROLE_ID);
		validateRequestParamNotNull(userId, userLogin, userEmail, userPassword, userSalt, userRoleId);

		return User.newBuilder().setId(getInt(userId)).setLogin(userLogin).setEmail(userEmail).setPassword(userPassword)
				.setSalt(userSalt).setRole_id(getInt(userRoleId)).build();
	}
}
