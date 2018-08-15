package by.htp.epam.cinema.web.action;

import javax.servlet.http.HttpServletRequest;

import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.ACTION_NAME_VIEW_HOME_PAGE;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_ACTION;

public class ActionManager {
	public static Actions defineAction(HttpServletRequest req) {
		String actionName = req.getParameter(REQUEST_PARAM_ACTION);
		if (actionName == null) {
			actionName = ACTION_NAME_VIEW_HOME_PAGE;
		}
		return Actions.valueOf(actionName.toUpperCase());
	}
}
