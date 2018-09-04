package by.htp.epam.cinema.db.dao;

import java.sql.SQLException;
import java.util.List;

import by.htp.epam.cinema.domain.Film;

/**
 * Interface provides specific methods for access to data in films table.
 * 
 * @author Arkadzi Patsko
 */
public interface FilmDao extends BaseDao<Film> {
	/**
	 * Gets all films which related to certain genre
	 * 
	 * @param genreId
	 *            id of genre
	 * @return list of films
	 */
	List<Film> readAllFilmsWhereGenreIdPresent(int genreId);

	/**
	 * Gets all films in given scope
	 * 
	 * @param start
	 *            start position for getting
	 * @param step
	 *            number of getting films
	 * 
	 * @return list of films
	 */
	List<Film> readAll(int start, int step);

	/**
	 * Adds films to database and relates it to given genres
	 * 
	 * @param film
	 *            film for adding
	 * @param genresId
	 *            list of genres id
	 * @throws SQLException
	 *             if SQLException occurs
	 */
	void createFilmWithGenres(Film film, List<Integer> genresId) throws SQLException;

	/**
	 * updates films in database and relates it to given genres
	 * 
	 * @param film
	 *            film for updating
	 * @param genresId
	 *            list of genres id
	 * @throws SQLException
	 *             if SQLException occurs
	 */
	void updateFilmWithGenres(Film film, List<Integer> genresId) throws SQLException;

	/**
	 * Gets not films but their count
	 * 
	 * @return count of all films
	 */
	int readCountOfAllFilms();

}
