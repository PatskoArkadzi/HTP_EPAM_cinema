package by.htp.epam.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.epam.cinema.db.dao.DaoFactory;
import by.htp.epam.cinema.db.dao.FilmDao;
import by.htp.epam.cinema.db.dao.FilmSessionDao;
import by.htp.epam.cinema.db.dao.SeatDao;
import by.htp.epam.cinema.db.dao.TicketDao;
import by.htp.epam.cinema.domain.BaseEntity;
import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Ticket;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.service.TicketService;

public class TicketServiceImpl implements TicketService {

	private TicketDao ticketDao = DaoFactory.getTicketDao();
	private FilmSessionDao filmSessionDao = DaoFactory.getFilmSessionDao();
	private FilmDao filmDao = DaoFactory.getFilmDao();
	private SeatDao seatDao = DaoFactory.getSeatDao();

	@Override
	public void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder) {
		Ticket ticket = Ticket.newBuilder().setId(0).setFilmSession_id(filmSession.getId()).setId(seat.getId())
				.setTicketsOrder_id(ticketsOrder.getId()).build();
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
