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
	SIGN_UP {
		{
			this.action = new SignUpAction();
			this.jspPage = PAGE_USER_SIGNUP;
		}
	},
	VIEW_GENRE_FILMS {
		{
			this.action = new ChosenGenreFilmsViewAction();
			this.jspPage = PAGE_USER_CHOSEN_GENRE_FILMS;
		}
	},
	VIEW_FILM_PAGE {
		{
			this.action = new FilmPageViewAction();
			this.jspPage = PAGE_USER_FILM;
		}
	},
	CHANGE_LOCALE {
		{
			this.action = new ChangeLocaleAction();
			this.jspPage = null;
		}
	},
	CHOOSE_SEAT {
		{
			this.action = new ChooseSeatAction();
			this.jspPage = PAGE_USER_SEAT_CHOICE;
		}
	},
	TO_BASKET {
		{
			this.action = new ToBasketAction();
			this.jspPage = null;
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
