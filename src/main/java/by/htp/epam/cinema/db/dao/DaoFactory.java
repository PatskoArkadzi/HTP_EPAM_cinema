package by.htp.epam.cinema.db.dao;

import by.htp.epam.cinema.db.dao.impl.FilmDaoImpl;
import by.htp.epam.cinema.db.dao.impl.FilmSessionDaoImpl;
import by.htp.epam.cinema.db.dao.impl.GenreDaoImpl;
import by.htp.epam.cinema.db.dao.impl.RoleDaoImpl;
import by.htp.epam.cinema.db.dao.impl.SeatDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketsOrderDaoImpl;
import by.htp.epam.cinema.db.dao.impl.UserDaoImpl;

public class DaoFactory {

	private DaoFactory() {
	}

	private static final FilmDao FILM_DAO = new FilmDaoImpl();
	private static final FilmSessionDao FILM_SESSION_DAO = new FilmSessionDaoImpl();
	private static final GenreDao GENRE_DAO = new GenreDaoImpl();
	private static final RoleDao ROLE_DAO = new RoleDaoImpl();
	private static final SeatDao SEAT_DAO = new SeatDaoImpl();
	private static final TicketDao TICKET_DAO = new TicketDaoImpl();
	private static final TicketsOrderDao TICKETS_ORDER_DAO = new TicketsOrderDaoImpl();
	private static final UserDao USER_DAO = new UserDaoImpl();

	public static FilmDao getFilmDao() {
		return FILM_DAO;
	}

	public static FilmSessionDao getFilmSessionDao() {
		return FILM_SESSION_DAO;
	}

	public static GenreDao getGenreDao() {
		return GENRE_DAO;
	}

	public static RoleDao getRoleDao() {
		return ROLE_DAO;
	}

	public static SeatDao getSeatDao() {
		return SEAT_DAO;
	}

	public static TicketDao getTicketDao() {
		return TICKET_DAO;
	}

	public static TicketsOrderDao getTicketsOrderDao() {
		return TICKETS_ORDER_DAO;
	}

	public static UserDao getUserDao() {
		return USER_DAO;
	}
}
