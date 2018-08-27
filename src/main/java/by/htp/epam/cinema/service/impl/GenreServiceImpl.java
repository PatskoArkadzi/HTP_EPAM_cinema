package by.htp.epam.cinema.service.impl;

import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.getInt;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateRequestParamNotNull;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_GENRES_ID;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.dao.DaoFactory;
import by.htp.epam.cinema.db.dao.GenreDao;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.service.GenreService;

public class GenreServiceImpl implements GenreService {

	private GenreDao genreDao = DaoFactory.getGenreDao();

	private static Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);

	@Override
	public List<Genre> getAllGenres() {
		return genreDao.readAll();
	}

	@Override
	public List<Genre> getFilmGenres(int filmId) {
		return genreDao.readAll(filmId);
	}

	@Override
	public Genre getGenre(int genreId) {
		return genreDao.read(genreId);
	}

	@Override
	public List<Integer> getFilmGenresId(HttpServletRequest request) {
		String[] genresId = request.getParameterValues(REQUEST_PARAM_FILM_GENRES_ID);
		validateRequestParamNotNull(genresId);
		List<Integer> genresIdList = new ArrayList<>();
		for (String genreId : genresId) {
			genresIdList.add(getInt(genreId));
		}
		return genresIdList;

	}
}
