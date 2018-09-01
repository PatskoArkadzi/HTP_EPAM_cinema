package by.htp.epam.cinema.db.dao;

import by.htp.epam.cinema.domain.User;

public interface UserDao extends BaseDao<User> {

	// List<User> readAllUsersWhereRoleIdPresent(int roleId);

	User readByLogin(String login);

	User readByEmail(String email);

}
