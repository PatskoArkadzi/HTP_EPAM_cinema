package by.htp.epam.cinema.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.Genre;

/**
 * Interface provides methods for working with Genre entity.
 * 
 * @author Arkadzi Patsko
 */
public interface GenreService extends Service {
	/**
	 * gets all genres
	 * 
	 * @return all found genres
	 */
	List<Genre> getAllGenres();

	/**
	 * gets all genres of certain film
	 * 
	 * @param filmId
	 *            id of film which genres we need to find
	 * @return list of film genres
	 */
	List<Genre> getFilmGenres(int filmId);

	/**
	 * gets genre by id
	 * 
	 * @param genreId
	 *            genre id
	 * @return found genre
	 */
	Genre getGenre(int genreId);

	/**
	 * gets list of genres id from request object
	 * 
	 * @param request
	 *            HttpServletRequest object with parameters
	 * @return list of found genres id
	 */
	List<Integer> getFilmGenresId(HttpServletRequest request);

}
