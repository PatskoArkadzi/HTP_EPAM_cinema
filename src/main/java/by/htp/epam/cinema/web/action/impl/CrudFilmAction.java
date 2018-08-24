package by.htp.epam.cinema.web.action.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.domain.Film;
import by.htp.epam.cinema.domain.Genre;
import by.htp.epam.cinema.service.FilmService;
import by.htp.epam.cinema.service.GenreService;
import by.htp.epam.cinema.service.UserService;
import by.htp.epam.cinema.service.impl.FilmServiceImpl;
import by.htp.epam.cinema.service.impl.GenreServiceImpl;
import by.htp.epam.cinema.service.impl.UserServiceImpl;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.HttpManager;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.*;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_ADMIN_CRUD_FILM;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_ERROR;
import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.ACTION_NAME_CRUD_FILM;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_CRUD_FILM_ACTION_INDEFINITE_ERROR;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_CRUD_FILM_ACTION_USER_IS_NOT_ADMIN;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.*;
import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.*;

public class CrudFilmAction implements BaseAction {

	private FilmService filmService = new FilmServiceImpl();
	private GenreService genreService = new GenreServiceImpl();
	private UserService userService = new UserServiceImpl();

	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!userService.isUserAdmin(request)) {
			request.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_CRUD_FILM_ACTION_USER_IS_NOT_ADMIN));
			request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
		}
		Map<Film, List<Genre>> filmWithGenres = filmService.getAllFilmsWithTheirGenres();
		List<Genre> allGenres = genreService.getAllGenres();
		request.setAttribute(REQUEST_PARAM_FILM_WITH_GENRES, filmWithGenres);
		request.setAttribute(SESSION_PARAM_GENRELIST, allGenres);
		if (isPost(request)) {
			String crudCommand = request.getParameter(REQUEST_PARAM_CRUD_COMMAND);
			System.out.println("crudCommand" + crudCommand);
			validateRequestParamNotNull(crudCommand);
			Film film;
			List<Integer> genresIdList;

			try {
				switch (crudCommand) {
				case REQUEST_PARAM_CRUD_VALUE_CREATE:
					film = buildFilm(request);
					genresIdList = getFilmGenresId(request);
					filmService.createFilm(film, genresIdList);
					break;
				case REQUEST_PARAM_CRUD_VALUE_READ:
					String filmId = request.getParameter(REQUEST_PARAM_FILM_ID);
					validateRequestParamNotNull(filmId);
					film = filmService.getFilm(getInt(filmId));
					request.setAttribute(REQUEST_PARAM_FOUND_FILM, film);
					request.getRequestDispatcher(PAGE_ADMIN_CRUD_FILM).forward(request, response);
					return;
				case REQUEST_PARAM_CRUD_VALUE_UPDATE:
					film = buildFilm(request);
					genresIdList = getFilmGenresId(request);
					filmService.updateFilmAndGenres(film, genresIdList);
					break;
				case REQUEST_PARAM_CRUD_VALUE_DELETE:
					film = buildFilm(request);
					filmService.deleteFilm(film);
					break;
				}
				response.sendRedirect(HttpManager.getLocationForRedirect(ACTION_NAME_CRUD_FILM));
				return;
			} catch (SQLException e) {
				request.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
						resourceManager.getValue(ERROR_MSG_CRUD_FILM_ACTION_INDEFINITE_ERROR));
				request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
			}
		}
		request.getRequestDispatcher(PAGE_ADMIN_CRUD_FILM).forward(request, response);
	}

	private Film buildFilm(HttpServletRequest req) {
		String id = req.getParameter(REQUEST_PARAM_FILM_ID);
		String filmName = req.getParameter(REQUEST_PARAM_FILM_NAME);
		String description = req.getParameter(REQUEST_PARAM_FILM_DESCRIPTION);
		String posterUrl = req.getParameter(REQUEST_PARAM_FILM_POSTER_URL);
		String youTubeVideoId = req.getParameter(REQUEST_PARAM_FILM_YOUTUBE_VIDEO_ID);
		validateRequestParamNotNull(id, filmName, description, posterUrl);

		Film film = new Film();
		film.setId(getInt(id));
		film.setFilmName(filmName);
		film.setDescription(description);
		film.setPosterUrl(fixGoogleDriveUrl(posterUrl));
		film.setYouTubeVideoId(youTubeVideoId);
		return film;
	}

	private List<Integer> getFilmGenresId(HttpServletRequest req) {
		String[] genresId = req.getParameterValues(REQUEST_PARAM_FILM_GENRES_ID);
		validateRequestParamNotNull(genresId);
		List<Integer> genresIdList = new ArrayList<>();
		for (String genreId : genresId) {
			genresIdList.add(getInt(genreId));
		}
		return genresIdList;
	}
}
