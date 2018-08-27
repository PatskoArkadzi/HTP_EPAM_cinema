package by.htp.epam.cinema.db.dao;

import by.htp.epam.cinema.db.dao.impl.FilmDaoImpl;
import by.htp.epam.cinema.db.dao.impl.FilmSessionDaoImpl;
import by.htp.epam.cinema.db.dao.impl.GenreDaoImpl;
import by.htp.epam.cinema.db.dao.impl.RoleDaoImpl;
import by.htp.epam.cinema.db.dao.impl.SeatDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketDaoImpl;
import by.htp.epam.cinema.db.dao.impl.TicketsOrderDaoImpl;
import by.htp.epam.cinema.db.dao.impl.UserDaoImpl;
import by.htp.epam.cinema.db.pool.BaseConnectionPool;

public class DaoFactory {

	private DaoFactory() {
	}

	private static final FilmDaoImpl filmDaoImpl = new FilmDaoImpl();
	private static final FilmSessionDaoImpl filmSessionDaoImpl = new FilmSessionDaoImpl();
	private static final GenreDaoImpl genreDaoImpl = new GenreDaoImpl();
	private static final RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
	private static final SeatDaoImpl seatDaoImpl = new SeatDaoImpl();
	private static final TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();
	private static final TicketsOrderDaoImpl ticketsOrderDaoImpl = new TicketsOrderDaoImpl();
	private static final UserDaoImpl userDaoImpl = new UserDaoImpl();

	public static FilmDao getFilmDao(BaseConnectionPool connectionPool) {
		filmDaoImpl.setConnectionPool(connectionPool);
		return filmDaoImpl;
	}

	public static FilmSessionDao getFilmSessionDao(BaseConnectionPool connectionPool) {
		filmSessionDaoImpl.setConnectionPool(connectionPool);
		return filmSessionDaoImpl;
	}

	public static GenreDao getGenreDao(BaseConnectionPool connectionPool) {
		genreDaoImpl.setConnectionPool(connectionPool);
		return genreDaoImpl;
	}

	public static RoleDao getRoleDao(BaseConnectionPool connectionPool) {
		roleDaoImpl.setConnectionPool(connectionPool);
		return roleDaoImpl;
	}

	public static SeatDao getSeatDao(BaseConnectionPool connectionPool) {
		seatDaoImpl.setConnectionPool(connectionPool);
		return seatDaoImpl;
	}

	public static TicketDao getTicketDao(BaseConnectionPool connectionPool) {
		ticketDaoImpl.setConnectionPool(connectionPool);
		return ticketDaoImpl;
	}

	public static TicketsOrderDao getTicketsOrderDao(BaseConnectionPool connectionPool) {
		ticketsOrderDaoImpl.setConnectionPool(connectionPool);
		return ticketsOrderDaoImpl;
	}

	public static UserDao getUserDao(BaseConnectionPool connectionPool) {
		userDaoImpl.setConnectionPool(connectionPool);
		return userDaoImpl;
	}
}
