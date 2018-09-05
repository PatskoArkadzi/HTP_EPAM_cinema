package by.htp.epam.cinema.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.FilmSession;

/**
 * Interface provides methods for working with FilmSession entity.
 * 
 * @author Arkadzi Patsko
 *
 */
public interface FilmSessionService extends Service {
	/**
	 * gets all filmSessions by film id
	 * 
	 * @param filmId
	 *            film id
	 * @return all found film sessions
	 */
	List<FilmSession> getFilmSessions(int filmId);

	/**
	 * gets film session by id
	 * 
	 * @param filmSessionId
	 *            film session id
	 * @return found film session
	 */
	FilmSession getFilmSession(int filmSessionId);

	/**
	 * builds film session with request parameters
	 * 
	 * @param request
	 *            HttpServletRequest object with parameters
	 * @return ready to use FilmSession object
	 */
	FilmSession buildFilmSession(HttpServletRequest request);

	/**
	 * creates film session
	 * 
	 * @param filmSession
	 *            creating film session
	 */
	void createFilmSession(FilmSession filmSession);

	/**
	 * updates film session
	 * 
	 * @param filmSession
	 *            updating film session
	 */
	void updateFilmSession(FilmSession filmSession);

	/**
	 * delete film session
	 * 
	 * @param filmSessionId
	 *            deleting film session id
	 */
	void deleteFilmSession(int filmSessionId);

	/**
	 * check possibility of film session removing
	 * 
	 * @param filmSessionId
	 *            removing film session id
	 * @return {@code true} if removing possible, {@code false} otherwise
	 */
	boolean isRemovalPossible(int filmSessionId);

	/**
	 * check film session time during creating and updating film session
	 * 
	 * @param filmSession
	 *            creating or updating film session
	 * @return {@code true} if film session time free, {@code false} otherwise
	 */
	boolean isFilmSessionTimeFree(FilmSession filmSession);

}
