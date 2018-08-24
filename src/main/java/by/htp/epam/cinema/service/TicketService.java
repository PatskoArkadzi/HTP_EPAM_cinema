package by.htp.epam.cinema.service;

import java.util.List;
import java.util.Map;

import by.htp.epam.cinema.domain.BaseEntity;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.Ticket;
import by.htp.epam.cinema.domain.TicketsOrder;

public interface TicketService extends Service {

	void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder);

	Map<Ticket, List<BaseEntity>> getOrderTickets(TicketsOrder order);

}
