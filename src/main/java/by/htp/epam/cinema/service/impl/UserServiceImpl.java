package by.htp.epam.cinema.service.impl;

import by.htp.epam.cinema.db.dao.UserDao;
import by.htp.epam.cinema.db.dao.impl.UserDaoImpl;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.UserService;
import by.htp.epam.cinema.web.util.PasswordSecurity;

import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.*;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

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
		else
			return "";
	}

	@Override
	public void addUser(User user) {
		userDao.create(user);
	}
}
