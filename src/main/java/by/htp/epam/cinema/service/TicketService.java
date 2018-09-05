package by.htp.epam.cinema.service;

import java.math.BigDecimal;
import java.util.List;

import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.CompositeEntities.CompositeTicket;

/**
 * Interface provides methods for working with Ticket entity.
 * 
 * @author Arkadzi Patsko
 */
public interface TicketService extends Service {
	/**
	 * creates ticket
	 * 
	 * @param filmSession
	 *            film session belonging to ticket
	 * @param seat
	 *            seat belonging to ticket
	 * @param ticketsOrder
	 *            order belonging to ticket
	 */
	void createTicket(FilmSession filmSession, Seat seat, TicketsOrder ticketsOrder);

	/**
	 * gets all tickets belonging to given order
	 * 
	 * @param order
	 *            order belonging to ticket
	 * @return all found tickets of given order
	 */
	List<CompositeTicket> getOrderTickets(TicketsOrder order);

	/**
	 * gets all sold tickets of certain film session in given scope
	 * 
	 * @param filmSessionId
	 *            film session id
	 * @param start
	 *            start position for getting
	 * @param step
	 *            number of getting tickets
	 * @return all found tickets of certain film session in given scope
	 */
	List<CompositeTicket> getAllFilmSessionSoldTickets(int filmSessionId, int start, int step);

	/**
	 * gets count of sold tickets of certain film session
	 * 
	 * @param filmSessionId
	 *            film session id
	 * @return sold tickets count
	 */
	int getSoldTicketCount(int filmSessionId);

	/**
	 * gets sum of sold tickets of certain film session
	 * 
	 * @param filmSessionId
	 *            film session id
	 * @return sold tickets sum
	 */
	BigDecimal getSoldTicketSum(int filmSessionId);

}
