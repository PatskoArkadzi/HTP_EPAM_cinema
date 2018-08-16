package by.htp.epam.cinema.service.impl;

import by.htp.epam.cinema.db.dao.UserDao;
import by.htp.epam.cinema.db.dao.impl.UserDaoImpl;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User getUser(String login, String password) {
		return userDao.read(login, password);
	}

}
