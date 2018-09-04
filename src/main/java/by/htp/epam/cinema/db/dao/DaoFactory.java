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

/**
 * Factory provides DAO instances
 * 
 * @author Arkadzi Patsko
 */
public class DaoFactory {
	/**
	 * Constructor without parameters
	 */
	private DaoFactory() {
	}

	/**
	 * Map for containing connection pools. So it's possible to use different
	 * implementation of BaseConnectionPool interface in DAO classes
	 */
	private static Map<Integer, BaseConnectionPool> connectionPools;

	/**
	 * FilmDaoImpl instance
	 */
	private static final FilmDaoImpl filmDaoImpl = new FilmDaoImpl();
	/**
	 * FilmSessionDaoImpl instance
	 */
	private static final FilmSessionDaoImpl filmSessionDaoImpl = new FilmSessionDaoImpl();
	/**
	 * GenreDaoImpl instance
	 */
	private static final GenreDaoImpl genreDaoImpl = new GenreDaoImpl();
	/**
	 * RoleDaoImpl instance
	 */
	private static final RoleDaoImpl roleDaoImpl = new RoleDaoImpl();
	/**
	 * SeatDaoImpl instance
	 */
	private static final SeatDaoImpl seatDaoImpl = new SeatDaoImpl();
	/**
	 * TicketDaoImpl instance
	 */
	private static final TicketDaoImpl ticketDaoImpl = new TicketDaoImpl();
	/**
	 * TicketsOrderDaoImpl instance
	 */
	private static final TicketsOrderDaoImpl ticketsOrderDaoImpl = new TicketsOrderDaoImpl();
	/**
	 * UserDaoImpl instance
	 */
	private static final UserDaoImpl userDaoImpl = new UserDaoImpl();

	/**
	 * The number of BaseConnectionPool implementation DaoFactory should use
	 */
	public static final int CUSTOM_CONNECTION_POOL = 1;

	static {
		connectionPools = new HashMap<>();
		connectionPools.put(CUSTOM_CONNECTION_POOL, CustomConnectionPool.getInstance());
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #filmDaoImpl}
	 */
	public static FilmDao getFilmDao(int connectionPoolNum) {
		filmDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return filmDaoImpl;
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #filmSessionDaoImpl}
	 */
	public static FilmSessionDao getFilmSessionDao(int connectionPoolNum) {
		filmSessionDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return filmSessionDaoImpl;
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #genreDaoImpl}
	 */
	public static GenreDao getGenreDao(int connectionPoolNum) {
		genreDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return genreDaoImpl;
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #roleDaoImpl}
	 */
	public static RoleDao getRoleDao(int connectionPoolNum) {
		roleDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return roleDaoImpl;
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #seatDaoImpl}
	 */
	public static SeatDao getSeatDao(int connectionPoolNum) {
		seatDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return seatDaoImpl;
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #ticketDaoImpl}
	 */
	public static TicketDao getTicketDao(int connectionPoolNum) {
		ticketDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return ticketDaoImpl;
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #ticketsOrderDaoImpl}
	 */
	public static TicketsOrderDao getTicketsOrderDao(int connectionPoolNum) {
		ticketsOrderDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return ticketsOrderDaoImpl;
	}

	/**
	 * @param connectionPoolNum
	 *            number of BaseConnectionPool implementation
	 * @return {@link #userDaoImpl}
	 */
	public static UserDao getUserDao(int connectionPoolNum) {
		userDaoImpl.setConnectionPool(connectionPools.get(connectionPoolNum));
		return userDaoImpl;
	}
}
