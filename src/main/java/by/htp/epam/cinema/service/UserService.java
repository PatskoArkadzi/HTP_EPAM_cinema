package by.htp.epam.cinema.service;

import by.htp.epam.cinema.domain.User;

public interface UserService extends Service {

	String checkUserData(String login, String email);

	User getUser(String login, String password) throws IllegalArgumentException;

	void createUser(String login, String email, String password);

}
