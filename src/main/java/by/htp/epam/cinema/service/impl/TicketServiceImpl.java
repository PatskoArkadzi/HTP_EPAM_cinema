package by.htp.epam.cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.epam.cinema.db.dao.FilmDao;
import by.htp.epam.cinema.db.dao.FilmSessionDao;
import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.dao.TicketDao;
import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Ticket;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.CompositeEntities.CompositeTicket;
import by.htp.epam.cinema.service.TicketService;

public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao;
	private FilmSessionDao filmSessionDao;
	private FilmDao filmDao;
	private SeatDao seatDao;

	public TicketServiceImpl(TicketDao ticketDao, FilmSessionDao filmSessionDao, FilmDao filmDao, SeatDao seatDao) {
		super();
		this.ticketDao = ticketDao;
		this.filmSessionDao = filmSessionDao;
		this.filmDao = filmDao;
		this.seatDao = seatDao;
	}

	@Override
	public void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder) {
		Ticket ticket = Ticket.newBuilder().setId(0).setFilmSessionId(filmSession.getId()).setSeatId(seat.getId())
				.setTicketsOrderId(ticketsOrder.getId()).build();
		ticketDao.create(ticket);
	}

	@Override
	public List<CompositeTicket> getOrderTickets(TicketsOrder order) {
		List<Ticket> tickets = ticketDao.readAllWhereOrderIdPresent(order.getId());
		List<CompositeTicket> compositeTickets = new ArrayList<>();
		for (Ticket t : tickets) {
			compositeTickets.add(getCompositeTicket(t, order));
		}
		return compositeTickets;
	}

	private CompositeTicket getCompositeTicket(Ticket ticket, TicketsOrder order) {
		CompositeTicket ct = new CompositeTicket();
		FilmSession filmSession = filmSessionDao.read(ticket.getFilmSessionId());
		Film film = filmDao.read(filmSession.getFilmId());
		Seat seat = seatDao.read(ticket.getSeatId());
		ct.setFilmSession(filmSession);
		ct.setFilm(film);
		ct.setSeat(seat);
		ct.setTicketsOrder(order);
		return new CompositeTicket(ticket.getId(), filmSession, film, seat, order);
	}
}
