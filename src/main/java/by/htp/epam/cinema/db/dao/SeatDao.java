package by.htp.epam.cinema.db.dao;

import by.htp.epam.cinema.domain.Seat;

/**
 * Interface provides specific methods for access to data in seats table.
 * 
 * @author Arkadzi Patsko
 */
public interface SeatDao extends BaseDao<Seat> {
	/**
	 * Gets seat by row and number
	 * 
	 * @param row
	 *            seat row
	 * @param number
	 *            seat time
	 * @return found seat
	 */
	Seat read(int row, int number);

}
