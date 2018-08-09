package by.htp.epam.cinema.db.dao;

import java.util.List;
import java.util.Map;

import by.htp.epam.cinema.domain.User;


public interface UserDao extends BaseDao<User> {

//	User readAllWhereEq(Map<String,Object> map);
//
//	List<User> readAllUsersWhereRoleIdPresent(int roleId);

	User read(String login, String password);

}
