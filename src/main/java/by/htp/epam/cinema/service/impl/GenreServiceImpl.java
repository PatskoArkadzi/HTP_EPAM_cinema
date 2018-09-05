package by.htp.epam.cinema.service.impl;

import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.getInt;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateRequestParamNotNull;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_GENRES_ID;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.db.dao.GenreDao;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.service.GenreService;

/**
 * Class implementing GenreService interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class GenreServiceImpl implements GenreService {
	/**
	 * genreDao
	 */
	private GenreDao genreDao;

	/**
	 * Constructor with parameters
	 * 
	 * @param genreDao
	 *            {@link #genreDao}
	 */
	public GenreServiceImpl(GenreDao genreDao) {
		this.genreDao = genreDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Genre> getAllGenres() {
		return genreDao.readAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Genre> getFilmGenres(int filmId) {
		return genreDao.readAll(filmId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Genre getGenre(int genreId) {
		return genreDao.read(genreId);
	}

	/**
	 * {@inheritDoc}
	 */
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
