package by.htp.epam.cinema.service.impl;

import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.db.dao.impl.TicketsOrderDaoImpl;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.TicketsOrderService;

public class TicketsOrderServiceImpl implements TicketsOrderService {
	TicketsOrderDao ticketsOrderDao = new TicketsOrderDaoImpl();

	@Override
	public TicketsOrder readUserNonPaidOrder(User user) {
		return ticketsOrderDao.read(user);
	}

	@Override
	public TicketsOrder createTicketsOrder(User user) {
		TicketsOrder ticketsOrder = new TicketsOrder();
		ticketsOrder.setUser_id(user.getId());
		ticketsOrderDao.create(ticketsOrder);
		return readUserNonPaidOrder(user);

	}

}
