package by.htp.epam.cinema.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.dao.FilmDao;
import by.htp.epam.cinema.db.dao.GenreDao;
import by.htp.epam.cinema.db.dao.impl.FilmDaoImpl;
import by.htp.epam.cinema.db.dao.impl.GenreDaoImpl;
import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.service.FilmService;

public class FilmServiceImpl implements FilmService {

	private FilmDao filmDao = new FilmDaoImpl();
	private GenreDao genreDao = new GenreDaoImpl();

	private static Logger logger = LoggerFactory.getLogger(FilmDaoImpl.class);

	@Override
	public Map<Film, List<Genre>> getAllFilmsWithTheirGenres() {
		List<Film> films = filmDao.readAll();
		return defineFilmsGenres(films);
	}

	@Override
	public Map<Film, List<Genre>> getAllFilmsWithTheirGenres(Genre genre) {
		List<Film> films = filmDao.readAllFilmsWhereGenreIdPresent(genre.getId());
		return defineFilmsGenres(films);
	}

	private Map<Film, List<Genre>> defineFilmsGenres(List<Film> films) {
		Map<Film, List<Genre>> filmsWithGenres = new LinkedHashMap<>();
		for (Film f : films) {
			filmsWithGenres.put(f, genreDao.readAll(f.getId()));
		}
		return filmsWithGenres;
	}

	@Override
	public Film getFilm(int filmId) {
		return filmDao.read(filmId);
	}
}
