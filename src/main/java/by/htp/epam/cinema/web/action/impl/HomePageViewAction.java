package by.htp.epam.cinema.web.action.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.service.FilmService;
import by.htp.epam.cinema.service.impl.FilmServiceImpl;
import by.htp.epam.cinema.web.action.BaseAction;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_FILM_WITH_GENRES;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_USER_MAIN;

import java.io.IOException;

public class HomePageViewAction implements BaseAction {

	private FilmService filmService = new FilmServiceImpl();

	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(REQUEST_PARAM_FILM_WITH_GENRES, filmService.getAllFilmsWithTheirGenres());
		request.getRequestDispatcher(PAGE_USER_MAIN).forward(request, response);
	}
}
