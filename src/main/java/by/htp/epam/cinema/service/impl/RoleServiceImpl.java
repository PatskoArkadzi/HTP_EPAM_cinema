package by.htp.epam.cinema.service.impl;

import java.util.List;

import by.htp.epam.cinema.db.dao.RoleDao;
import by.htp.epam.cinema.db.dao.impl.RoleDaoImpl;
import by.htp.epam.cinema.domain.Role;
import by.htp.epam.cinema.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao = new RoleDaoImpl();

	@Override
	public List<Role> getAll() {
		return roleDao.readAll();
	}

}