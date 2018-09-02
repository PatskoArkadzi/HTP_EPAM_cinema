package by.htp.epam.cinema.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.domain.CompositeEntities.CompositeFilm;

public interface FilmService extends Service {

	/**
	 * get all films without their genres
	 */
	List<Film> getAllFilms();

	/**
	 * get films with all their genres from start to start+step
	 * 
	 * @param step
	 * @param step
	 */
	List<CompositeFilm> getFilmsWithTheirGenres(int start, int step);

	/**
	 * get all films with all their genres
	 */
	List<CompositeFilm> getAllFilmsWithTheirGenres();

	/**
	 * get only that films which belong to given genre
	 */
	List<CompositeFilm> getAllFilmsWithTheirGenres(Genre genre);

	/**
	 * get film by id
	 */
	Film getFilm(int filmId);

	/**
	 * create Film and its genres
	 * 
	 * @throws SQLException
	 */
	void createFilm(Film film, List<Integer> genresId) throws SQLException;

	/**
	 * create Film and its genres
	 * 
	 * @throws SQLException
	 */
	void updateFilmAndGenres(Film film, List<Integer> genresId) throws SQLException;

	/**
	 * create Film and its genres
	 */
	void deleteFilm(Film film);

	/**
	 * build Film
	 */
	Film buildFilm(HttpServletRequest request);

	/**
	 * get count of all films
	 */
	int getAllFilmsCount();
}
