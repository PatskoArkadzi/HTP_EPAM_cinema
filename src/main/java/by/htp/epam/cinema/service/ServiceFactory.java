package by.htp.epam.cinema.service;

import static by.htp.epam.cinema.db.dao.DaoFactory.CUSTOM_CONNECTION_POOL;
import static by.htp.epam.cinema.db.dao.DaoFactory.getFilmDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getFilmSessionDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getGenreDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getRoleDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getSeatDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getTicketDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getTicketsOrderDao;
import static by.htp.epam.cinema.db.dao.DaoFactory.getUserDao;

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

	private static final FilmService FILM_SERVICE = new FilmServiceImpl(getFilmDao(CUSTOM_CONNECTION_POOL),
			getGenreDao(CUSTOM_CONNECTION_POOL));
	private static final FilmSessionService FILM_SESSION_SERVICE = new FilmSessionServiceImpl(
			getFilmSessionDao(CUSTOM_CONNECTION_POOL), getTicketDao(CUSTOM_CONNECTION_POOL));
	private static final GenreService GENRE_SERVICE = new GenreServiceImpl(getGenreDao(CUSTOM_CONNECTION_POOL));
	private static final RoleService ROLE_SERVICE = new RoleServiceImpl(getRoleDao(CUSTOM_CONNECTION_POOL));
	private static final SeatService SEAT_SERVICE = new SeatServiceImpl(getSeatDao(CUSTOM_CONNECTION_POOL),
			getTicketsOrderDao(CUSTOM_CONNECTION_POOL));
	private static final TicketService TICKET_SERVICE = new TicketServiceImpl(getTicketDao(CUSTOM_CONNECTION_POOL),
			getFilmSessionDao(CUSTOM_CONNECTION_POOL), getFilmDao(CUSTOM_CONNECTION_POOL),
			getSeatDao(CUSTOM_CONNECTION_POOL));
	private static final TicketsOrderService TICKETS_ORDER_SERVICE = new TicketsOrderServiceImpl(
			getTicketsOrderDao(CUSTOM_CONNECTION_POOL));
	private static final UserService USER_SERVICE = new UserServiceImpl(getUserDao(CUSTOM_CONNECTION_POOL));

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
