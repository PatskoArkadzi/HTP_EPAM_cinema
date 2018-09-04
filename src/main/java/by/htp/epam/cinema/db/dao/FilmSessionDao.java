package by.htp.epam.cinema.db.dao;

import java.util.List;

import by.htp.epam.cinema.domain.FilmSession;

/**
 * Interface provides specific methods for access to data in sessions table.
 * 
 * @author Arkadzi Patsko
 */
public interface FilmSessionDao extends BaseDao<FilmSession> {
	/**
	 * Gets all filmSessions which related to certain film
	 * 
	 * @param filmId
	 *            id of film
	 * @return list of film sessions
	 */
	List<FilmSession> readAll(int filmId);

	/**
	 * Gets filmSession which occurs at given date and time
	 * 
	 * @param date
	 *            date of film session
	 * @param time
	 *            time of film session
	 * @return found film session
	 */
	FilmSession readByDateAndTime(String date, String time);
}
