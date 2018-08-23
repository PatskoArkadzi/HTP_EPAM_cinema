package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.web.action.BaseAction;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_LOCALE_LANGUAGE;

import java.io.IOException;
import java.util.Locale;

import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.REQUEST_PARAM_LOCALE_COUNTRY;

public class ChangeLocaleAction implements BaseAction {

	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String language = request.getParameter(REQUEST_PARAM_LOCALE_LANGUAGE);
		String country = request.getParameter(REQUEST_PARAM_LOCALE_COUNTRY);
		resourceManager.changeResource(new Locale(language, country));
		response.sendRedirect(request.getHeader("Referer"));
	}
}
