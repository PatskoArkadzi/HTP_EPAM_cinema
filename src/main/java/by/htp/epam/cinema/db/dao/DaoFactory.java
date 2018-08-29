package by.htp.epam.cinema.db.dao;

import java.util.HashMap;
import java.util.Map;

import by.htp.epam.cinema.db.dao.impl.FilmDaoImpl;
import by.htp.epam.cinema.db.dao.impl.FilmSessionDaoImpl;
import by.htp.epam.cinema.db.dao.impl.GenreDaoImpl;
import by.htp.epam.cinema.db.dao.impl.RoleDaoImpl;
import by.htp.epam.cinema.db.dao.impl.SeatDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketsOrderDaoImpl;
import by.htp.epam.cinema.db.dao.impl.UserDaoImpl;
import by.htp.epam.cinema.db.pool.BaseConnectionPool;
import by.htp.epam.cinema.db.pool.impl.CustomConnectionPool;

public class DaoFactory {

	private DaoFactory() {
	}

	private static Map<Integer, BaseConnectionPool> connectionPools;
	private static final FilmDaoImpl FILM_DAO_IMPL = new FilmDaoImpl();
	private static final FilmSessionDaoImpl FILM_SESSION_DAO_IMPL = new FilmSessionDaoImpl();
	private static final GenreDaoImpl GENRE_DAO_IMPL = new GenreDaoImpl();
	private static final RoleDaoImpl ROLE_DAO_IMPL = new RoleDaoImpl();
	private static final SeatDaoImpl SEAT_DAO_IMPL = new SeatDaoImpl();
	private static final TicketDaoImpl TICKET_DAO_IMPL = new TicketDaoImpl();
	private static final TicketsOrderDaoImpl TICKETS_ORDER_DAO_IMPL = new TicketsOrderDaoImpl();
	private static final UserDaoImpl USER_DAO_IMPL = new UserDaoImpl();

	public static final int CUSTOM_CONNECTION_POOL = 1;

	static {
		connectionPools = new HashMap<>();
		connectionPools.put(CUSTOM_CONNECTION_POOL, CustomConnectionPool.getInstance());
	}

	public static FilmDao getFilmDao(int connectionPoolNum) {
		FILM_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return FILM_DAO_IMPL;
	}

	public static FilmSessionDao getFilmSessionDao(int connectionPoolNum) {
		FILM_SESSION_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return FILM_SESSION_DAO_IMPL;
	}

	public static GenreDao getGenreDao(int connectionPoolNum) {
		GENRE_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return GENRE_DAO_IMPL;
	}

	public static RoleDao getRoleDao(int connectionPoolNum) {
		ROLE_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return ROLE_DAO_IMPL;
	}

	public static SeatDao getSeatDao(int connectionPoolNum) {
		SEAT_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return SEAT_DAO_IMPL;
	}

	public static TicketDao getTicketDao(int connectionPoolNum) {
		TICKET_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return TICKET_DAO_IMPL;
	}

	public static TicketsOrderDao getTicketsOrderDao(int connectionPoolNum) {
		TICKETS_ORDER_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return TICKETS_ORDER_DAO_IMPL;
	}

	public static UserDao getUserDao(int connectionPoolNum) {
		USER_DAO_IMPL.setConnectionPool(connectionPools.get(connectionPoolNum));
		return USER_DAO_IMPL;
	}
}
