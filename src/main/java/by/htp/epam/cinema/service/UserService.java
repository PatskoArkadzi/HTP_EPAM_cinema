package by.htp.epam.cinema.service;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.User;

public interface UserService extends Service {

	String checkUserData(String login, String email);

	User getUser(String login, String password) throws IllegalArgumentException;

	void createUser(String login, String email, String password);

	boolean isUserAdmin(HttpServletRequest request);

	User getUser(int userId);

	void updateUser(User user);

}
