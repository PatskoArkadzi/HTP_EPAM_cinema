package by.htp.epam.cinema.service;

import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;

public interface TicketService extends Service {

	void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder);

}
