package by.htp.epam.cinema.db.dao;

import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.domain.TicketsOrder;
import by.htp.epam.cinema.domain.User;

public interface TicketsOrderDao extends BaseDao<TicketsOrder> {

	// List<TicketsOrder> readAllWhereEq(String property, Object object);

	/**
	 * read order for checking seat free or not
	 */
	TicketsOrder read(int seatId, int filmSessionId);

	/**
	 * read one user non-paid order
	 */
	TicketsOrder read(User user);

}
