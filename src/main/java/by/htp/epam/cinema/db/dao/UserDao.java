package by.htp.epam.cinema.db.dao;

import by.htp.epam.cinema.domain.User;

/**
 * Interface provides specific methods for access to data in users table.
 * 
 * @author Arkadzi Patsko
 */
public interface UserDao extends BaseDao<User> {
	/**
	 * Gets seat by login
	 * 
	 * @param login
	 *            user login
	 * @return found user
	 */
	User readByLogin(String login);

	/**
	 * Gets seat by email
	 * 
	 * @param email
	 *            user email
	 * @return found user
	 */
	User readByEmail(String email);

}
