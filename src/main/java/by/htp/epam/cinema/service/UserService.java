package by.htp.epam.cinema.service;

import by.htp.epam.cinema.domain.User;

public interface UserService extends Service {

	User getUser(String login, String password);

}
