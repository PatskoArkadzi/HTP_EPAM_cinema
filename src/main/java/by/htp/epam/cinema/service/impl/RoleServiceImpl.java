package by.htp.epam.cinema.service.impl;

import java.util.List;

import by.htp.epam.cinema.db.dao.RoleDao;
import by.htp.epam.cinema.domain.Role;
import by.htp.epam.cinema.service.RoleService;
import static by.htp.epam.cinema.db.dao.DaoFactory.getRoleDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.CUSTOM_CONNECTION_POOL;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao = getRoleDao(CUSTOM_CONNECTION_POOL);

	@Override
	public List<Role> getAll() {
		return roleDao.readAll();
	}

}
