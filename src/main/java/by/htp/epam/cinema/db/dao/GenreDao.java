package by.htp.epam.cinema.db.dao;

import java.util.List;

import by.htp.epam.cinema.domain.Genre;

/**
 * Interface provides specific methods for access to data in genres table.
 * 
 * @author Arkadzi Patsko
 */
public interface GenreDao extends BaseDao<Genre> {
	/**
	 * Gets all genres which related to given film
	 * 
	 * @param filmId
	 *            id of film
	 * @return list of genres
	 */
	List<Genre> readAll(int filmId);
}
