package by.htp.epam.cinema.service;

import by.htp.epam.cinema.service.impl.FilmServiceImpl;
import by.htp.epam.cinema.service.impl.FilmSessionServiceImpl;
import by.htp.epam.cinema.service.impl.GenreServiceImpl;
import by.htp.epam.cinema.service.impl.RoleServiceImpl;
import by.htp.epam.cinema.service.impl.SeatServiceImpl;
import by.htp.epam.cinema.service.impl.TicketServiceImpl;
import by.htp.epam.cinema.service.impl.TicketsOrderServiceImpl;
import by.htp.epam.cinema.service.impl.UserServiceImpl;

public class ServiceFactory {

	private ServiceFactory() {
	}

	private static final FilmService FILM_SERVICE = new FilmServiceImpl();
	private static final FilmSessionService FILM_SESSION_SERVICE = new FilmSessionServiceImpl();
	private static final GenreService GENRE_SERVICE = new GenreServiceImpl();
	private static final RoleService ROLE_SERVICE = new RoleServiceImpl();
	private static final SeatService SEAT_SERVICE = new SeatServiceImpl();
	private static final TicketService TICKET_SERVICE = new TicketServiceImpl();
	private static final TicketsOrderService TICKETS_ORDER_SERVICE = new TicketsOrderServiceImpl();
	private static final UserService USER_SERVICE = new UserServiceImpl();

	public static FilmService getFilmService() {
		return FILM_SERVICE;
	}

	public static FilmSessionService getFilmSessionService() {
		return FILM_SESSION_SERVICE;
	}

	public static GenreService getGenreService() {
		return GENRE_SERVICE;
	}

	public static RoleService getRoleService() {
		return ROLE_SERVICE;
	}

	public static SeatService getSeatService() {
		return SEAT_SERVICE;
	}

	public static TicketService getTicketService() {
		return TICKET_SERVICE;
	}

	public static TicketsOrderService getTicketsOrderService() {
		return TICKETS_ORDER_SERVICE;
	}

	public static UserService getUserService() {
		return USER_SERVICE;
	}
}
