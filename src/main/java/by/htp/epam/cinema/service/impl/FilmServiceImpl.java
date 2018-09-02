package by.htp.epam.cinema.service.impl;

import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.fixGoogleDriveUrl;
import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.getInt;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateRequestParamNotNull;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_DESCRIPTION;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_ID;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_NAME;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_POSTER_URL;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_YOUTUBE_VIDEO_ID;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.db.dao.FilmDao;
import by.htp.epam.cinema.db.dao.GenreDao;
import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.domain.CompositeEntities.CompositeFilm;
import by.htp.epam.cinema.service.FilmService;

public class FilmServiceImpl implements FilmService {

	private FilmDao filmDao;
	private GenreDao genreDao;

	public FilmServiceImpl(FilmDao filmDao, GenreDao genreDao) {
		this.filmDao = filmDao;
		this.genreDao = genreDao;
	}

	@Override
	public List<Film> getAllFilms() {
		return filmDao.readAll();
	}

	@Override
	public List<CompositeFilm> getAllFilmsWithTheirGenres() {
		List<Film> films = filmDao.readAll();
		return defineFilmsGenres(films);
	}

	@Override
	public List<CompositeFilm> getAllFilmsWithTheirGenres(Genre genre) {
		List<Film> films = filmDao.readAllFilmsWhereGenreIdPresent(genre.getId());
		return defineFilmsGenres(films);
	}

	private List<CompositeFilm> defineFilmsGenres(List<Film> films) {
		List<CompositeFilm> filmsWithGenres = new ArrayList<>();
		for (Film f : films) {
			CompositeFilm cf = new CompositeFilm(f.getId(), f.getFilmName(), f.getDescription(), f.getPosterUrl(),
					f.getYouTubeVideoId(), genreDao.readAll(f.getId()));
			filmsWithGenres.add(cf);
		}
		return filmsWithGenres;
	}

	@Override
	public Film getFilm(int filmId) {
		return filmDao.read(filmId);
	}

	@Override
	public void createFilm(Film film, List<Integer> genresId) throws SQLException {
		filmDao.createFilmWithGenres(film, genresId);
	}

	@Override
	public void updateFilmAndGenres(Film film, List<Integer> genresId) throws SQLException {
		filmDao.updateFilmWithGenres(film, genresId);
	}

	@Override
	public void deleteFilm(Film film) {
		filmDao.delete(film.getId());
	}

	@Override
	public Film buildFilm(HttpServletRequest request) {
		String id = request.getParameter(REQUEST_PARAM_FILM_ID);
		String filmName = request.getParameter(REQUEST_PARAM_FILM_NAME);
		String description = request.getParameter(REQUEST_PARAM_FILM_DESCRIPTION);
		String posterUrl = request.getParameter(REQUEST_PARAM_FILM_POSTER_URL);
		String youTubeVideoId = request.getParameter(REQUEST_PARAM_FILM_YOUTUBE_VIDEO_ID);
		validateRequestParamNotNull(id, filmName, description, posterUrl);
		return Film.newBuilder().setId(getInt(id)).setFilmName(filmName).setDescription(description)
				.setPosterUrl(fixGoogleDriveUrl(posterUrl)).setYouTubeVideoId(youTubeVideoId).build();
	}
}
