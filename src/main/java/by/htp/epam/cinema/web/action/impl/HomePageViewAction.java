package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.service.FilmService;
import by.htp.epam.cinema.service.impl.FilmServiceImpl;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_WITH_GENRES;

public class HomePageViewAction extends BaseAction {

	private FilmService filmService = new FilmServiceImpl();

	@Override
	public Actions executeAction(HttpServletRequest request) {
		request.setAttribute(REQUEST_PARAM_FILM_WITH_GENRES, filmService.getAllFilmsWithTheirGenres());
		return Actions.HOME;
	}
}
