package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_LOCALE_LANGUAGE;

import java.util.Locale;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_LOCALE_COUNTRY;

public class ChangeLocaleAction extends BaseAction {

	@Override
	public Actions executeAction(HttpServletRequest request) {
		String language = request.getParameter(REQUEST_PARAM_LOCALE_LANGUAGE);
		String country = request.getParameter(REQUEST_PARAM_LOCALE_COUNTRY);
		resourceManager.changeResource(new Locale(language, country));
		return Actions.CHANGE_LOCALE;
	}
}
