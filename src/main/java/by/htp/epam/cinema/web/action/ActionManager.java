package by.htp.epam.cinema.web.action;

import by.htp.epam.cinema.web.action.impl.ChangeLocaleAction;
import by.htp.epam.cinema.web.action.impl.ChooseSeatAction;
import by.htp.epam.cinema.web.action.impl.ChosenGenreFilmsViewAction;
import by.htp.epam.cinema.web.action.impl.ErrorPageViewAction;
import by.htp.epam.cinema.web.action.impl.FilmPageViewAction;
import by.htp.epam.cinema.web.action.impl.HomePageViewAction;
import by.htp.epam.cinema.web.action.impl.LogInAction;
import by.htp.epam.cinema.web.action.impl.LogOutAction;
import by.htp.epam.cinema.web.action.impl.SignUpAction;
import by.htp.epam.cinema.web.action.impl.ToBasketAction;

import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.*;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_ACTION;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionManager {
	private static Map<String, BaseAction> actions;

	static {
		actions = new HashMap<>();
		actions.put(ACTION_NAME_VIEW_HOME_PAGE, new HomePageViewAction());
		actions.put(ACTION_NAME_VIEW_FILM_PAGE, new FilmPageViewAction());
		actions.put(ACTION_NAME_VIEW_ERROR_PAGE, new ErrorPageViewAction());
		actions.put(ACTION_NAME_VIEW_CHOSEN_GENRE_FILMS, new ChosenGenreFilmsViewAction());
		actions.put(ACTION_NAME_LOGOUT, new LogOutAction());
		actions.put(ACTION_NAME_LOGIN, new LogInAction());
		actions.put(ACTION_NAME_SIGNUP, new SignUpAction());
		actions.put(ACTION_NAME_CHOOSE_SEAT, new ChooseSeatAction());
		actions.put(ACTION_NAME_TO_BASKET, new ToBasketAction());
		actions.put(ACTION_NAME_CHANGE_LOCALE, new ChangeLocaleAction());
		// actions.put(ACTION_NAME_VIEW_PROFILE,);
	}

	public static BaseAction defineAction(HttpServletRequest req) {
		String actionName = req.getParameter(REQUEST_PARAM_ACTION);
		if (actionName == null) {
			actionName = ACTION_NAME_VIEW_HOME_PAGE;
		}
		return actions.get(actionName);
	}
}
