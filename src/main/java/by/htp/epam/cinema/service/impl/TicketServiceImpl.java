package by.htp.epam.cinema.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import by.htp.epam.cinema.db.dao.FilmDao;
import by.htp.epam.cinema.db.dao.FilmSessionDao;
import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.dao.TicketDao;
import by.htp.epam.cinema.db.dao.TicketsOrderDao;
import by.htp.epam.cinema.db.dao.UserDao;
import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Ticket;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.domain.CompositeEntities.CompositeTicket;
import by.htp.epam.cinema.service.TicketService;

/**
 * Class implementing TicketService interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class TicketServiceImpl implements TicketService {
	/**
	 * ticketDao
	 */
	private TicketDao ticketDao;
	/**
	 * filmSessionDao
	 */
	private FilmSessionDao filmSessionDao;
	/**
	 * filmDao
	 */
	private FilmDao filmDao;
	/**
	 * seatDao
	 */
	private SeatDao seatDao;
	/**
	 * ticketsOrderDao
	 */
	private TicketsOrderDao ticketsOrderDao;
	/**
	 * userDao
	 */
	private UserDao userDao;

	/**
	 * Constructor with parameters
	 * 
	 * @param ticketDao
	 *            {@link #ticketDao}
	 * @param filmSessionDao
	 *            {@link #filmSessionDao}
	 * @param filmDao
	 *            {@link #filmDao}
	 * @param seatDao
	 *            {@link #seatDao}
	 * @param ticketsOrderDao
	 *            {@link #ticketsOrderDao}
	 * @param userDao
	 *            {@link #userDao}
	 */
	public TicketServiceImpl(TicketDao ticketDao, FilmSessionDao filmSessionDao, FilmDao filmDao, SeatDao seatDao,
			TicketsOrderDao ticketsOrderDao, UserDao userDao) {
		this.ticketDao = ticketDao;
		this.filmSessionDao = filmSessionDao;
		this.filmDao = filmDao;
		this.seatDao = seatDao;
		this.ticketsOrderDao = ticketsOrderDao;
		this.userDao = userDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder) {
		Ticket ticket = Ticket.newBuilder().setId(0).setFilmSessionId(filmSession.getId()).setSeatId(seat.getId())
				.setTicketsOrderId(ticketsOrder.getId()).build();
		ticketDao.create(ticket);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CompositeTicket> getOrderTickets(TicketsOrder order) {
		List<Ticket> tickets = ticketDao.readAllWhereOrderIdPresent(order.getId());
		List<CompositeTicket> compositeTickets = new ArrayList<>();
		if (tickets != null) {
			for (Ticket t : tickets) {
				compositeTickets.add(getCompositeTicket(t));
			}
		}
		return compositeTickets;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CompositeTicket> getAllFilmSessionSoldTickets(int filmSessionId, int start, int step) {
		List<Ticket> tickets = ticketDao.readAllSoldTicketsByFilmSessionId(filmSessionId, start, step);
		List<CompositeTicket> compositeTickets = new ArrayList<>();
		if (tickets != null) {
			for (Ticket t : tickets) {
				compositeTickets.add(getCompositeTicket(t));
			}
		}
		return compositeTickets;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSoldTicketCount(int filmSessionId) {
		return ticketDao.readCountOfSoldTickets(filmSessionId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getSoldTicketSum(int filmSessionId) {
		return ticketDao.readSumOfSoldTickets(filmSessionId);
	}

	/**
	 * gets ticket with related entities for passing it to request context
	 * 
	 * @param ticket
	 *            ticket
	 * @return ticket with related entities
	 */
	private CompositeTicket getCompositeTicket(Ticket ticket) {
		FilmSession filmSession = filmSessionDao.read(ticket.getFilmSessionId());
		Film film = filmDao.read(filmSession.getFilmId());
		Seat seat = seatDao.read(ticket.getSeatId());
		TicketsOrder order = ticketsOrderDao.read(ticket.getTicketsOrderId());
		User user = userDao.read(order.getUserId());
		return new CompositeTicket(ticket.getId(), filmSession, film, seat, order, user);
	}
}
