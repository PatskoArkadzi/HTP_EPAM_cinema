package by.htp.epam.cinema.service;

import java.util.List;

import by.htp.epam.cinema.domain.Genre;

public interface GenreService extends Service {

	List<Genre> getAllGenres();

	List<Genre> getFilmGenres(int filmId);

	Genre getGenre(int genreId);

}
