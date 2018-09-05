package by.htp.epam.cinema.service;

import java.util.List;

import by.htp.epam.cinema.domain.Seat;

/**
 * Interface provides methods for working with Seat entity.
 * 
 * @author Arkadzi Patsko
 */
public interface SeatService extends Service {
	/**
	 * gets all seats with their states by film session id
	 * 
	 * @param filmSessionId
	 *            film session id
	 * @return list of seats with their states
	 */
	List<Seat> getSeatsWithState(int filmSessionId);

	/**
	 * check is seat free
	 * 
	 * @param seatId
	 *            checking seat id
	 * @param filmSessionId
	 *            film session id
	 * @return {@code true} if seat free, {@code false} otherwise
	 */
	boolean isSeatFree(int seatId, int filmSessionId);

	/**
	 * gets seat by id
	 * 
	 * @param seatId
	 *            seat id
	 * @return found seat
	 */
	Seat getSeat(int seatId);

}
