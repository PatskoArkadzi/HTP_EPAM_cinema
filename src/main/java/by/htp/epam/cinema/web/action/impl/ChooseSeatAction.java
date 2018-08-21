package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.domain.FilmSession;
import by.htp.epam.cinema.domain.Seat;
import by.htp.epam.cinema.service.FilmSessionService;
import by.htp.epam.cinema.service.SeatService;
import by.htp.epam.cinema.service.impl.FilmSessionServiceImpl;
import by.htp.epam.cinema.service.impl.SeatServiceImpl;
import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.ValidateNullParamException;

import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateRequestParamNotNull;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_FILMSESSION;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_SEATS_WITH_STATES;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_CHOSEN_FILMSESSION_ID;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_CHOOSE_SEAT_ACTION_INDEFINITE_ERROR;

import java.util.List;

public class ChooseSeatAction extends BaseAction {

	SeatService seatService = new SeatServiceImpl();
	FilmSessionService filmSessionService = new FilmSessionServiceImpl();

	@Override
	public Actions executeAction(HttpServletRequest request) {
		String chosenFilmSessionId = request.getParameter(REQUEST_PARAM_CHOSEN_FILMSESSION_ID);
		try {
			validateRequestParamNotNull(chosenFilmSessionId);
			FilmSession chosenFilmSession = filmSessionService.getFilmSession(Integer.parseInt(chosenFilmSessionId));
			List<Seat> seatsWithStates = seatService.getSeatsWithState(chosenFilmSession.getId());
			request.setAttribute(REQUEST_PARAM_CHOSEN_FILMSESSION, chosenFilmSession);
			request.setAttribute(REQUEST_PARAM_SEATS_WITH_STATES, seatsWithStates);
			return Actions.CHOOSE_SEAT;
		} catch (ValidateNullParamException e) {
			request.getSession().setAttribute(SESSION_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_CHOOSE_SEAT_ACTION_INDEFINITE_ERROR));
			return Actions.ERROR;
		}
	}
}
