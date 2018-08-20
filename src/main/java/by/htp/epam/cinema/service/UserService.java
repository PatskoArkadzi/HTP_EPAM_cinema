package by.htp.epam.cinema.service;

import by.htp.epam.cinema.domain.User;

public interface UserService extends Service {

	String checkUserData(String login, String email);

	void addUser(User user);

	User getUser(String login, String password) throws IllegalArgumentException;

}
