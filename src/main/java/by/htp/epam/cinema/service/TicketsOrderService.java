package by.htp.epam.cinema.service;

import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;

/**
 * Interface provides methods for working with TicketOrder entity.
 * 
 * @author Arkadzi Patsko
 */
public interface TicketsOrderService extends Service {
	/**
	 * gets non paid order belonging to given user
	 * 
	 * @param user
	 *            user for search
	 * @return non paid order
	 */
	TicketsOrder readUserNonPaidOrder(User user);

	/**
	 * creates order for given user
	 * 
	 * @param user
	 *            user for creating
	 * @return created order
	 */
	TicketsOrder createTicketsOrder(User user);

	/**
	 * deletes non paid order belonging to given user
	 * 
	 * @param user
	 *            user for deleting
	 */
	void deleteNonPaidOrder(User user);

	/**
	 * update isPaid fild for certain order
	 * 
	 * @param ticketOrderId
	 *            order id for updating
	 */
	void payOrder(int ticketOrderId);

}
