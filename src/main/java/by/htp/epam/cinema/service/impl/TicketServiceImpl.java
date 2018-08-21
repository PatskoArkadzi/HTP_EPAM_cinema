package by.htp.epam.cinema.service.impl;

import by.htp.epam.cinema.db.dao.TicketDao;
import by.htp.epam.cinema.db.dao.impl.TicketDaoImpl;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Ticket;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.service.TicketService;

public class TicketServiceImpl implements TicketService {
	TicketDao ticketDao = new TicketDaoImpl();

	@Override
	public void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder) {
		Ticket ticket = new Ticket(0, filmSession.getId(), seat.getId(), ticketsOrder.getId());
		ticketDao.create(ticket);
	}
}
