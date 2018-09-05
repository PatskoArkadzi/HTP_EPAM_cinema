package by.htp.epam.cinema.service.impl;

import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.TicketsOrderService;

/**
 * Class implementing TicketsOrderService interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class TicketsOrderServiceImpl implements TicketsOrderService {
	/**
	 * ticketsOrderDao
	 */
	private TicketsOrderDao ticketsOrderDao;

	/**
	 * Constructor with parameters
	 * 
	 * @param ticketsOrderDao
	 *            {@link #ticketsOrderDao}
	 */
	public TicketsOrderServiceImpl(TicketsOrderDao ticketsOrderDao) {
		this.ticketsOrderDao = ticketsOrderDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TicketsOrder readUserNonPaidOrder(User user) {
		return ticketsOrderDao.readByUserId(user.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TicketsOrder createTicketsOrder(User user) {
		TicketsOrder ticketsOrder = TicketsOrder.newBuilder().setUserId(user.getId()).build();
		ticketsOrderDao.create(ticketsOrder);
		return readUserNonPaidOrder(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteNonPaidOrder(User user) {
		TicketsOrder order = readUserNonPaidOrder(user);
		if (order != null) {
			ticketsOrderDao.delete(order.getId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void payOrder(int ticketOrderId) {
		TicketsOrder ticketsOrder = ticketsOrderDao.read(ticketOrderId);
		ticketsOrder.setIsPaid(true);
		ticketsOrderDao.update(ticketsOrder);
	}
}
