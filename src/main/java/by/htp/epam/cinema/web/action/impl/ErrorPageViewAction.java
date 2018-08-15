package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.SESSION_PARAM_ERROR_MESSAGE;

public class ErrorPageViewAction extends BaseAction {

	@Override
	public Actions executeAction(HttpServletRequest request) {
		return Actions.ERROR;
	}
}
