package by.htp.epam.cinema.web.action;

import by.htp.epam.cinema.web.action.impl.ChosenGenreFilmsViewAction;
import by.htp.epam.cinema.web.action.impl.ErrorPageViewAction;
import by.htp.epam.cinema.web.action.impl.HomePageViewAction;
import by.htp.epam.cinema.web.action.impl.LogInAction;
import by.htp.epam.cinema.web.action.impl.LogOutAction;

import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.*;

public enum Actions {

	HOME {
		{
			this.action = new HomePageViewAction();
			this.jspPage = PAGE_USER_MAIN;
		}
	},
	LOG_IN {
		{
			this.action = new LogInAction();
			this.jspPage = PAGE_USER_LOGIN;
		}
	},
	LOG_OUT {
		{
			this.action = new LogOutAction();
			this.jspPage = null;
		}
	},
	VIEW_GENRE_FILMS {
		{
			this.action = new ChosenGenreFilmsViewAction();
			this.jspPage = PAGE_USER_CHOSEN_GENRE_FILMS;
		}
	},
	ERROR {
		{
			this.action = new ErrorPageViewAction();
			this.jspPage = PAGE_ERROR;
		}
	};

	public BaseAction action;
	public String jspPage;

}
