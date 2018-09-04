package by.htp.epam.cinema.db.dao;

import by.htp.epam.cinema.domain.TicketsOrder;

/**
 * Interface provides specific methods for access to data in orders table.
 * 
 * @author Arkadzi Patsko
 */
public interface TicketsOrderDao extends BaseDao<TicketsOrder> {

	/**
	 * read order for checking seat free or not
	 * 
	 * @param seatId
	 *            seat id
	 * @param filmSessionId
	 *            film session id
	 * @return found ticketsOrder
	 */
	TicketsOrder read(int seatId, int filmSessionId);

	/**
	 * read one user non-paid order
	 * 
	 * @param userId
	 *            user id
	 * @return found ticketsOrder
	 */
	TicketsOrder readByUserId(int userId);

}
