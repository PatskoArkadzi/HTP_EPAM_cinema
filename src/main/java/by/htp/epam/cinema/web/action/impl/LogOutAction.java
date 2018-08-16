package by.htp.epam.cinema.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.web.action.Actions;
import by.htp.epam.cinema.web.action.BaseAction;

public class LogOutAction extends BaseAction {

	@Override
	public Actions executeAction(HttpServletRequest request) {
		request.getSession().invalidate();
		return Actions.HOME;
	}

}
