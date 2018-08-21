package by.htp.epam.cinema.web.action.impl;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_GENRE_ID;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_GENRE_FILMS_VIEW_ACTION_INDEFINITE_ERROR;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.*;
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
import by.htp.epam.cinema.web.util.ValidateNullParamException;

public class ChosenGenreFilmsViewAction extends BaseAction {

	private FilmService filmService = new FilmServiceImpl();
	private GenreService genreService = new GenreServiceImpl();
	private static Logger logger = LoggerFactory.getLogger(ChosenGenreFilmsViewAction.class);

	@Override
	public Actions executeAction(HttpServletRequest request) {
		String chosenGenreId = request.getParameter(REQUEST_PARAM_CHOSEN_GENRE_ID);
		System.out.println("chosenGenreId"+chosenGenreId);
		try {
			validateRequestParamNotNull(chosenGenreId);
			Genre genre = genreService.getGenre(Integer.parseInt(chosenGenreId));
			request.setAttribute(REQUEST_PARAM_CHOSEN_GENRE_FILMS, filmService.getAllFilmsWithTheirGenres(genre));
			request.setAttribute(REQUEST_PARAM_CHOSEN_GENRE, genre);
			return Actions.VIEW_GENRE_FILMS;
		} catch (ValidateNullParamException e) {
			request.getSession().setAttribute(SESSION_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_GENRE_FILMS_VIEW_ACTION_INDEFINITE_ERROR));
			return Actions.ERROR;
		}
	}
}
