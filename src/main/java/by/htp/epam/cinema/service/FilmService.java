package by.htp.epam.cinema.service;

import java.util.List;
import java.util.Map;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;

public interface FilmService extends Service {

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

}
