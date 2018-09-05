package by.htp.epam.cinema.service;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.User;

/**
 * Interface provides methods for working with User entity.
 * 
 * @author Arkadzi Patsko
 */
public interface UserService extends Service {
	/**
	 * checks user data during sign up
	 * 
	 * @param login
	 *            user login
	 * @param email
	 *            user email
	 * @param password
	 *            user password
	 * @return result of check: if success - "", otherwise error message
	 */
	String checkUserData(String login, String email, String password);

	/**
	 * gets user by login, password
	 * 
	 * @param login
	 *            user login
	 * @param password
	 *            user password
	 * @return found user
	 */
	User getUser(String login, String password);

	/**
	 * creates new user
	 * 
	 * @param login
	 *            user login
	 * @param email
	 *            user email
	 * @param password
	 *            user password
	 */
	void createUser(String login, String email, String password);

	/**
	 * checks is user role admin
	 * 
	 * @param request
	 *            HttpServletRequest object
	 * @return {@code true} if user is admin, {@code false} otherwise
	 */
	boolean isUserAdmin(HttpServletRequest request);

	/**
	 * gets user by id
	 * 
	 * @param userId
	 *            user id
	 * @return found user
	 */
	User getUser(int userId);

	/**
	 * updates user
	 * 
	 * @param user
	 *            updating user
	 */
	void updateUser(User user);

	/**
	 * builds user with request parameters
	 * 
	 * @param request
	 *            HttpServletRequest object with parameters
	 * @return ready to use User object
	 */
	User buildUser(HttpServletRequest request);

	/**
	 * changes user password if it possible
	 * 
	 * @param userId
	 *            user id
	 * @param oldPassword
	 *            old user password
	 * @param newPassword
	 *            new user password
	 * @return User object with changing password, otherwise null
	 */
	User changeUserPassword(int userId, String oldPassword, String newPassword);

	/**
	 * checks user login
	 * 
	 * @param login
	 *            user login
	 * @return appropriate message as a result of check
	 */
	String checkUserLogin(String login);

	/**
	 * checks user email
	 * 
	 * @param email
	 *            user email
	 * @return appropriate message as a result of check
	 */
	String checkUserEmail(String email);

	/**
	 * checks user password
	 * 
	 * @param password
	 *            user password
	 * @return appropriate message as a result of check
	 */
	String checkUserPassword(String password);

}
