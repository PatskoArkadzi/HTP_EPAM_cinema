package by.htp.epam.cinema.db.dao;

import java.math.BigDecimal;
import java.util.List;

import by.htp.epam.cinema.domain.Ticket;

/**
 * Interface provides specific methods for access to data in tickets table.
 * 
 * @author Arkadzi Patsko
 */
public interface TicketDao extends BaseDao<Ticket> {
	/**
	 * Gets all tickets which related to certain order
	 * 
	 * @param orderId
	 *            id of order
	 * @return list of tickets
	 */
	List<Ticket> readAllWhereOrderIdPresent(int orderId);

	/**
	 * Gets all tickets which related to certain film session
	 * 
	 * @param filmSessionId
	 *            id of filmSession
	 * @return list of tickets
	 */
	List<Ticket> readAllWhereFilmSessionIdPresent(int filmSessionId);

	/**
	 * Gets all sold tickets in given scope which related to certain film session
	 * 
	 * @param filmSessionId
	 *            id of filmSession
	 * @param start
	 *            start position for getting
	 * @param step
	 *            number of getting tickets
	 * @return list of tickets
	 */
	List<Ticket> readAllSoldTicketsByFilmSessionId(int filmSessionId, int start, int step);

	/**
	 * Gets count of sold tickets which related to certain film session
	 * 
	 * @param filmSessionId
	 *            film session id
	 * @return count of sold tickets
	 */
	int readCountOfSoldTickets(int filmSessionId);

	/**
	 * Gets sum of sold tickets which related to certain film session
	 * 
	 * @param filmSessionId
	 *            film session id
	 * @return sum of sold tickets
	 */
	BigDecimal readSumOfSoldTickets(int filmSessionId);

}
