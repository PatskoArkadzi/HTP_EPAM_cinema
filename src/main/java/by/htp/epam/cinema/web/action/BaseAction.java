package by.htp.epam.cinema.web.action;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseAction {

	public abstract Actions executeAction(HttpServletRequest request);

	@Override
	public String toString() {
		return getClass().getSimpleName().replace("Action", "");
	}

}
