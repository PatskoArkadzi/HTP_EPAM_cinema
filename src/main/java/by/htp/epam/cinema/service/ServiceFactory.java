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

/**
 * Factory provides Service instances
 * 
 * @author Arkadzi Patsko
 */
public class ServiceFactory {
	/**
	 * Constructor without parameters
	 */
	private ServiceFactory() {
	}

	/**
	 * FilmService instance
	 */
	private static final FilmService filmService = new FilmServiceImpl(getFilmDao(CUSTOM_CONNECTION_POOL),
			getGenreDao(CUSTOM_CONNECTION_POOL));
	/**
	 * FilmSessionService instance
	 */
	private static final FilmSessionService filmSessionService = new FilmSessionServiceImpl(
			getFilmSessionDao(CUSTOM_CONNECTION_POOL), getTicketDao(CUSTOM_CONNECTION_POOL));
	/**
	 * GenreService instance
	 */
	private static final GenreService genreService = new GenreServiceImpl(getGenreDao(CUSTOM_CONNECTION_POOL));
	/**
	 * RoleService instance
	 */
	private static final RoleService roleService = new RoleServiceImpl(getRoleDao(CUSTOM_CONNECTION_POOL));
	/**
	 * SeatService instance
	 */
	private static final SeatService seatService = new SeatServiceImpl(getSeatDao(CUSTOM_CONNECTION_POOL),
			getTicketsOrderDao(CUSTOM_CONNECTION_POOL));
	/**
	 * TicketService instance
	 */
	private static final TicketService ticketService = new TicketServiceImpl(getTicketDao(CUSTOM_CONNECTION_POOL),
			getFilmSessionDao(CUSTOM_CONNECTION_POOL), getFilmDao(CUSTOM_CONNECTION_POOL),
			getSeatDao(CUSTOM_CONNECTION_POOL), getTicketsOrderDao(CUSTOM_CONNECTION_POOL),
			getUserDao(CUSTOM_CONNECTION_POOL));
	/**
	 * TicketsOrderService instance
	 */
	private static final TicketsOrderService ticketsOrderService = new TicketsOrderServiceImpl(
			getTicketsOrderDao(CUSTOM_CONNECTION_POOL));
	/**
	 * UserService instance
	 */
	private static final UserService userService = new UserServiceImpl(getUserDao(CUSTOM_CONNECTION_POOL));

	/**
	 * @return {@link #filmService}
	 */
	public static FilmService getFilmService() {
		return filmService;
	}

	/**
	 * @return {@link #filmSessionService}
	 */
	public static FilmSessionService getFilmSessionService() {
		return filmSessionService;
	}

	/**
	 * @return {@link #genreService}
	 */
	public static GenreService getGenreService() {
		return genreService;
	}

	/**
	 * @return {@link #roleService}
	 */
	public static RoleService getRoleService() {
		return roleService;
	}

	/**
	 * @return {@link #seatService}
	 */
	public static SeatService getSeatService() {
		return seatService;
	}

	/**
	 * @return {@link #ticketService}
	 */
	public static TicketService getTicketService() {
		return ticketService;
	}

	/**
	 * @return {@link #ticketsOrderService}
	 */
	public static TicketsOrderService getTicketsOrderService() {
		return ticketsOrderService;
	}

	/**
	 * @return {@link #userService}
	 */
	public static UserService getUserService() {
		return userService;
	}
}
