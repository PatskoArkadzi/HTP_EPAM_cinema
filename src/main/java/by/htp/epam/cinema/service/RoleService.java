package by.htp.epam.cinema.service;

import java.util.List;

import by.htp.epam.cinema.domain.Role;

/**
 * Interface provides methods for working with Role entity.
 * 
 * @author Arkadzi Patsko
 */
public interface RoleService extends Service {
	/**
	 * gets all roles
	 * 
	 * @return all found roles
	 */
	List<Role> getAll();

}
