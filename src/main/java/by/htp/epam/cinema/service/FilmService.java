package by.htp.epam.cinema.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.domain.CompositeEntities.CompositeFilm;

/**
 * Interface provides methods for working with Film entity.
 * 
 * @author Arkadzi Patsko
 */
public interface FilmService extends Service {

	/**
	 * gets all films without their genres
	 * 
	 * @return all found films
	 */
	List<Film> getAllFilms();

	/**
	 * gets films with all their genres from start to start+step
	 * 
	 * @param start
	 *            start position for getting
	 * @param step
	 *            number of getting films
	 * 
	 * @return all found films with their genre in given scope
	 */
	List<CompositeFilm> getFilmsWithTheirGenres(int start, int step);

	/**
	 * gets only that films which related to given genre
	 * 
	 * @param genre
	 *            genre which films is need to define
	 * 
	 * @return all found genre films
	 */
	List<CompositeFilm> getAllFilmsWithTheirGenres(Genre genre);

	/**
	 * gets film by id
	 * 
	 * @param filmId
	 *            film id
	 * @return found film
	 */
	Film getFilm(int filmId);

	/**
	 * creates Film and its genres
	 * 
	 * @param film
	 *            creating film
	 * @param genresId
	 *            list of film genres id
	 * 
	 * @throws SQLException
	 *             if SQLException occurred in FilmDao class
	 */
	void createFilm(Film film, List<Integer> genresId) throws SQLException;

	/**
	 * updates Film and its genres
	 * 
	 * @param film
	 *            updating film
	 * @param genresId
	 *            list of film genres id
	 * 
	 * @throws SQLException
	 *             if SQLException occurred in FilmDao class
	 */
	void updateFilmAndGenres(Film film, List<Integer> genresId) throws SQLException;

	/**
	 * deletes Film
	 * 
	 * @param film
	 *            deleting film
	 */
	void deleteFilm(Film film);

	/**
	 * build Film with request parameters
	 * 
	 * @param request
	 *            HttpServletRequest object with parameters
	 * @return ready to use film object
	 */
	Film buildFilm(HttpServletRequest request);

	/**
	 * get count of all films
	 * 
	 * @return count of all films
	 */
	int getAllFilmsCount();

	/**
	 * get one film with genres by film id
	 * 
	 * @param filmId
	 *            film id
	 * @return film with list of genres
	 */
	CompositeFilm getFilmWithGenres(int filmId);
}
