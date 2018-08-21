package by.htp.epam.cinema.web.action;

import javax.servlet.http.HttpServletRequest;

import by.htp.epam.cinema.web.util.ResourceManager;

public abstract class BaseAction {

	protected ResourceManager resourceManager = ResourceManager.LOCALIZATION;

	public abstract Actions executeAction(HttpServletRequest request);

	@Override
	public String toString() {
		return getClass().getSimpleName().replace("Action", "");
	}

}
