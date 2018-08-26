package by.htp.epam.cinema.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;

public interface FilmService extends Service {

	/**
	 * get all films without their genres
	 */
	List<Film> getAllFilms();

	/**
	 * get all films with all their genres
	 */
	Map<Film, List<Genre>> getAllFilmsWithTheirGenres();

	/**
	 * get only that films which belog to given genre
	 */
	Map<Film, List<Genre>> getAllFilmsWithTheirGenres(Genre genre);

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

}
