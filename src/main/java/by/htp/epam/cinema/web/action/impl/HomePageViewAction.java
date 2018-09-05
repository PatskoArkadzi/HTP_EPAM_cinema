package by.htp.epam.cinema.web.action.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.service.FilmService;
import by.htp.epam.cinema.service.ServiceFactory;
import by.htp.epam.cinema.web.action.BaseAction;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_WITH_GENRES;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_PAGINATION_START;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_PAGINATION_STEP;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_ALL_FILMS_COUNT;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_USER_MAIN;
import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.getInt;

import java.io.IOException;

/**
 * Class implementing BaseAction interface
 * 
 * @author Arkadzi Patsko
 *
 */
public class HomePageViewAction implements BaseAction {
	/**
	 * filmService field
	 */
	private FilmService filmService = ServiceFactory.getFilmService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqStart = request.getParameter(REQUEST_PARAM_PAGINATION_START);
		String reqStep = request.getParameter(REQUEST_PARAM_PAGINATION_STEP);
		int start = reqStart != null ? getInt(reqStart) : 0;
		int step = reqStep != null ? getInt(reqStep) : 5;

		request.setAttribute(REQUEST_PARAM_FILM_WITH_GENRES, filmService.getFilmsWithTheirGenres(start, step));
		request.setAttribute(REQUEST_PARAM_ALL_FILMS_COUNT, filmService.getAllFilmsCount());
		request.getRequestDispatcher(PAGE_USER_MAIN).forward(request, response);
	}
}
