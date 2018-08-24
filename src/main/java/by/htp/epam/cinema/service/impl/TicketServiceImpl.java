package by.htp.epam.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.epam.cinema.db.dao.FilmDao;
import by.htp.epam.cinema.db.dao.FilmSessionDao;
import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.dao.TicketDao;
import by.htp.epam.cinema.db.dao.impl.FilmDaoImpl;
import by.htp.epam.cinema.db.dao.impl.FilmSessionDaoImpl;
import by.htp.epam.cinema.db.dao.impl.SeatDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketDaoImpl;
import by.htp.epam.cinema.domain.BaseEntity;
import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Ticket;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.service.TicketService;

public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao = new TicketDaoImpl();
	private FilmSessionDao filmSessionDao = new FilmSessionDaoImpl();
	private FilmDao filmDao = new FilmDaoImpl();
	private SeatDao seatDao = new SeatDaoImpl();

	@Override
	public void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder) {
		Ticket ticket = new Ticket(0, filmSession.getId(), seat.getId(), ticketsOrder.getId());
		ticketDao.create(ticket);
	}

	@Override
	public Map<Ticket, List<BaseEntity>> getOrderTickets(TicketsOrder order) {
		List<Ticket> tickets = ticketDao.readAllWhereOrderIdPresent(order.getId());
		Map<Ticket, List<BaseEntity>> currentOrderTickets = new HashMap<>();
		for (Ticket t : tickets) {
			currentOrderTickets.put(t, getRelatedEntities(t));
		}
		return currentOrderTickets;
	}

	private List<BaseEntity> getRelatedEntities(Ticket ticket) {
		List<BaseEntity> relatedEntities = new ArrayList<>();
		FilmSession filmSession = filmSessionDao.read(ticket.getFilmSession_id());
		relatedEntities.add(filmSession);
		Film film = filmDao.read(filmSession.getFilm_id());
		relatedEntities.add(film);
		Seat seat = seatDao.read(ticket.getSeat_id());
		relatedEntities.add(seat);
		return relatedEntities;
	}
}
