package by.htp.epam.cinema.service.impl;

import by.htp.epam.cinema.db.dao.DaoFactory;
import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.db.pool.impl.ConnectionPool;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.TicketsOrderService;
import by.htp.epam.cinema.web.util.Timer;

public class TicketsOrderServiceImpl implements TicketsOrderService {
	private TicketsOrderDao ticketsOrderDao = DaoFactory.getTicketsOrderDao(ConnectionPool.getInstance());

	@Override
	public TicketsOrder readUserNonPaidOrder(User user) {
		return ticketsOrderDao.read(user);
	}

	@Override
	public TicketsOrder createTicketsOrder(User user) {
		TicketsOrder ticketsOrder = TicketsOrder.newBuilder().setUser_id(user.getId()).build();
		ticketsOrderDao.create(ticketsOrder);
		return readUserNonPaidOrder(user);
	}

	@Override
	public void deleteNonPaidOrder(User user) {
		TicketsOrder order = readUserNonPaidOrder(user);
		if (order != null) {
			ticketsOrderDao.delete(order.getId());
		}
	}

	@Override
	public void payOrder(int ticketOrderId) {
		TicketsOrder ticketsOrder = ticketsOrderDao.read(ticketOrderId);
		ticketsOrder.setIsPaid(true);
		ticketsOrderDao.update(ticketsOrder);
		Timer.getInstance().setStop(true);
	}
}
