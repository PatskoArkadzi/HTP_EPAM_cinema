package by.htp.epam.cinema.web.action.impl;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_GENRE_ID;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_GENRE;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_GENRE_FILMS;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.service.FilmService;
import by.htp.epam.cinema.service.GenreService;
import by.htp.epam.cinema.service.impl.FilmServiceImpl;
import by.htp.epam.cinema.service.impl.GenreServiceImpl;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;

public class ChosenGenreFilmsViewAction extends BaseAction {

	private FilmService filmService = new FilmServiceImpl();
	private GenreService genreService = new GenreServiceImpl();
	private static Logger logger = LoggerFactory.getLogger(ChosenGenreFilmsViewAction.class);

	@Override
	public Actions executeAction(HttpServletRequest request) {
		int genreId = Integer.parseInt(request.getParameter(REQUEST_PARAM_CHOSEN_GENRE_ID));
		Genre genre = genreService.getGenre(genreId);
		request.setAttribute(REQUEST_PARAM_CHOSEN_GENRE_FILMS, filmService.getAllFilmsWithTheirGenres(genre));
		request.setAttribute(REQUEST_PARAM_CHOSEN_GENRE, genre);
		return Actions.VIEW_GENRE_FILMS;
	}
}
