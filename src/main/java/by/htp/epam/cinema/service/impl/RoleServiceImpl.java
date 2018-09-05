package by.htp.epam.cinema.service.impl;

import java.util.List;

import by.htp.epam.cinema.db.dao.RoleDao;
import by.htp.epam.cinema.domain.Role;
import by.htp.epam.cinema.service.RoleService;

/**
 * Class implementing RoleService interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class RoleServiceImpl implements RoleService {
	/**
	 * roleDao
	 */
	private RoleDao roleDao;

	/**
	 * Constructor with parameters
	 * 
	 * @param roleDao
	 *            {@link #roleDao}
	 */
	public RoleServiceImpl(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> getAll() {
		return roleDao.readAll();
	}

}
