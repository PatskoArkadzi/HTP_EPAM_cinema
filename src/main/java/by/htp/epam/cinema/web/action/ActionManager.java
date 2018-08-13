package by.htp.epam.cinema.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.web.action.impl.ChosenGenreFilmsViewAction;
import by.htp.epam.cinema.web.action.impl.HomePageViewAction;
import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.ACTION_NAME_VIEW_HOME_PAGE;
import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.ACTION_NAME_VIEW_CHOSEN_GENRE_FILMS;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_ACTION;

public class ActionManager {

	private static Map<String, BaseAction> actions;

	static {
		actions = new HashMap<String, BaseAction>();
		actions.put(ACTION_NAME_VIEW_HOME_PAGE, new HomePageViewAction());
		actions.put(ACTION_NAME_VIEW_CHOSEN_GENRE_FILMS, new ChosenGenreFilmsViewAction());
	}

	public static BaseAction defineAction(HttpServletRequest req) {
		String actionName = req.getParameter(REQUEST_PARAM_ACTION);
		return actions.get(actionName);
	}

}
