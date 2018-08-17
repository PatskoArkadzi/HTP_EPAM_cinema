package by.htp.epam.cinema.web.action.impl;

import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.*;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_FILM_ID;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_FILM;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_FILM_GENRES;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_FILM_SESSIONS;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.service.FilmService;
import by.htp.epam.cinema.service.FilmSessionService;
import by.htp.epam.cinema.service.GenreService;
import by.htp.epam.cinema.service.impl.FilmServiceImpl;
import by.htp.epam.cinema.service.impl.FilmSessionServiceImpl;
import by.htp.epam.cinema.service.impl.GenreServiceImpl;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;

public class FilmPageViewAction extends BaseAction {

	private FilmService filmService = new FilmServiceImpl();
	private GenreService genreService = new GenreServiceImpl();
	private FilmSessionService filmSessionService = new FilmSessionServiceImpl();

	@Override
	public Actions executeAction(HttpServletRequest request) {
		String filmId = request.getParameter(REQUEST_PARAM_CHOSEN_FILM_ID);
		if (validateRequestParamNotNull(filmId)) {
			int chosenFilmid = Integer.parseInt(filmId);
			Film chosenFilm = filmService.getFilm(chosenFilmid);
			List<Genre> chosenFilmGenres = genreService.getFilmGenres(chosenFilmid);
			List<FilmSession> chosenFilmSessions = filmSessionService.getFilmSessions(chosenFilmid);
			request.setAttribute(REQUEST_PARAM_CHOSEN_FILM, chosenFilm);
			request.setAttribute(REQUEST_PARAM_CHOSEN_FILM_GENRES, chosenFilmGenres);
			request.setAttribute(REQUEST_PARAM_CHOSEN_FILM_SESSIONS, chosenFilmSessions);
			return Actions.VIEW_FILM_PAGE;
		} else {
			request.getSession().setAttribute(SESSION_PARAM_ERROR_MESSAGE, "Something went wrong. Try again.");
			return Actions.ERROR;
		}
	}
}
