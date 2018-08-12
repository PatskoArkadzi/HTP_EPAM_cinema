package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.service.FilmService;
import by.htp.epam.cinema.service.impl.FilmServiceImpl;
import by.htp.epam.cinema.web.action.BaseAction;

import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_USER_MAIN;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_WITH_GENRES;

public class HomePageViewAction implements BaseAction {

	private FilmService filmService = new FilmServiceImpl();

	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute(REQUEST_PARAM_FILM_WITH_GENRES, filmService.getAllFilmsWithTheirGenres());
		return PAGE_USER_MAIN;
	}
}
